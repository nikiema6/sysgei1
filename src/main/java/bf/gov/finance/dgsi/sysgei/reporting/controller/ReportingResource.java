/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.reporting.controller;

import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingInputDto;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingResponseDto;
import bf.gov.finance.dgsi.sysgei.service.AdministrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/sysgei/")
public class ReportingResource {
    private final AdministrationService reportingService;

    /**
     * Ressource globale de génération des états.
     *
     * @param inputDto
     * @return ResponseEntity<byte [ ]>
     * @throws IOException
     * @throws JRException
     */
    @PostMapping(path = "/reporting")
    @Operation(summary = "Endpoint permettant de générer un état.",
            tags = {"Etats"}, responses = {@ApiResponse(responseCode = "200", description = "Si la création reussi"),
            @ApiResponse(responseCode = "400", description = "En cas d'erreur de validation"),
            @ApiResponse(responseCode = "401", description = "Paramères de connexion incorrectes"),
            @ApiResponse(responseCode = "500", description = "En cas d'erreur inattendue")})
    public ResponseEntity<byte[]> generateReport(@RequestBody @Valid final ReportingInputDto inputDto)
            throws IOException, JRException {
        ReportingResponseDto responseDto = reportingService.generateReport(inputDto);
        return new ResponseEntity<>(responseDto.getReportFile(), HttpStatus.CREATED);
    }
}
