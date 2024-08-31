/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.reporting.config;

import bf.gov.finance.dgsi.sysgei.domain.enumm.ReportFormat;
import bf.gov.finance.dgsi.sysgei.domain.enumm.ReportSource;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingInputDto;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 10/10/2023
 **/
@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("ALL")
public class ReportConfigService {
    private final ReportingTemplateConfig.ReportingTemplate reportingTemplate;
    @Value("${spring.profiles.active}")
    private String profile;

    /**
     * Building du rapport.
     *
     * @param inputDto
     * @param dto
     * @param parameterMap
     * @return ReportingResponseDto
     * @throws IOException
     * @throws JRException
     */
    public ReportingResponseDto buildReport(
            final ReportingInputDto inputDto, final Object dto,
            final HashMap<String, ? super Object> parameterMap) throws IOException, JRException {

        // recuperation du fichier jasper
        final String reportTemplate = reportingTemplate.getTemplateMap()
                .get(inputDto.getReportType().name());

        if (null == reportTemplate) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "reportType " + inputDto.getReportType().name()
                            + " jasper template is missing in the config object");
        }
        InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream(reportTemplate);
        // convert DTO into the JsonDatasource
        InputStream jsonFile = this.convertDtoToInputStream(dto);
        JRDataSource jsonDataSource = new JsonDataSource(jsonFile);
        byte[] reportFile = this.genererRapport(fileInputStream,
                parameterMap, jsonDataSource, inputDto.getReportFormat(),
                ReportSource.BINARY);
        return new ReportingResponseDto(reportFile);
    }

    /**
     * Convertir en inputStream.
     *
     * @param dto
     * @return InputStream
     * @throws IOException
     */
    private InputStream convertDtoToInputStream(final Object dto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Java object to JSON string
        String jsonString = mapper.writeValueAsString(dto);
        if (this.profile.equals("dev")) {
            log.debug("\n ==== Json String: {}", jsonString);
            this.createJsonFile(jsonString);
        }
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
        return inputStream;
    }

    /**
     * Création json file.
     *
     * @param str
     * @throws IOException
     */
    private void createJsonFile(final String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("json_file.json"));
        writer.write(str);
        writer.close();
    }

    /**
     * generation du rapport en byte[].
     *
     * @param inputStream
     * @param parametres
     * @param jsonDataSource
     * @param format
     * @param source
     * @return byte[]
     */
    private byte[] genererRapport(
            @NotNull final InputStream inputStream,
            final HashMap<String, ? super Object> parametres,
            final JRDataSource jsonDataSource,
            @NotNull final ReportFormat format,
            @NotNull final ReportSource source) {
        byte[] fluxFichier = null;
        JasperPrint jasperPrint = null;
        try {
            if (source.equals(ReportSource.SOURCE)) {
                JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
                jasperPrint = JasperFillManager.fillReport(jasperReport, parametres, jsonDataSource);
            } else {
                jasperPrint = JasperFillManager.fillReport(inputStream, parametres, jsonDataSource);
            }
            switch (format) {
                case PDF:
                    fluxFichier = exportToPDF(jasperPrint);
                    break;
                case EXCEL:
                    fluxFichier = exportToExcel(jasperPrint);
                    break;
                case CSV:
                    fluxFichier = exportToCSV(jasperPrint);
                    break;
                case WORD:
                    fluxFichier = exportToWord(jasperPrint);
                    break;
                default:
                    return null;
            }
        } catch (Exception ex) {
            log.error("Erreur de generation du reports", ex);
        }
        return fluxFichier;
    }


    /**
     * Cette méthode permet de generer un état sous format PDF.
     *
     * @param documentImprimable
     * @return un flux de bytes de données
     * @throws JRException
     */
    private byte[] exportToPDF(final JasperPrint documentImprimable) throws JRException {
        return JasperExportManager.exportReportToPdf(documentImprimable);
    }

    /**
     * Cette méthode permet de générer un état sous format Excel.
     *
     * @param doc
     * @return un tableau de bytes
     * @throws JRException
     */
    private byte[] exportToExcel(final JasperPrint doc) throws JRException {
        ByteArrayOutputStream excelReportStream = new ByteArrayOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(doc));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(excelReportStream));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(false);
        configuration.setDetectCellType(true);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        return excelReportStream.toByteArray();
    }

    /**
     * Cette méthode permet de générer un état sous format CSV.
     *
     * @param doc
     * @return un tableau de bytes
     * @throws JRException
     */
    private byte[] exportToCSV(final JasperPrint doc) throws JRException {
        ByteArrayOutputStream excelReportStream = new ByteArrayOutputStream();
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(doc));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(excelReportStream));
        exporter.exportReport();
        return excelReportStream.toByteArray();

    }

    /**
     * Cette méthode permet de générer un état sous format WORD.
     *
     * @param doc
     * @return un tableau de bytes
     * @throws JRException
     */
    private byte[] exportToWord(final JasperPrint doc) throws JRException {
        ByteArrayOutputStream wordReportStream = new ByteArrayOutputStream();
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(doc));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(wordReportStream));
        SimpleDocxExporterConfiguration configuration = new SimpleDocxExporterConfiguration();
        configuration.setEmbedFonts(Boolean.TRUE);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
        return wordReportStream.toByteArray();
    }
}
