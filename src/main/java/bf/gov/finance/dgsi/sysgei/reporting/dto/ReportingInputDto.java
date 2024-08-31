/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.reporting.dto;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EReportType;
import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import bf.gov.finance.dgsi.sysgei.domain.enumm.ReportFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : <a href="siguizana08@gmail.com">BRAHIMA TRAORE </a>.
 * @version : 1.0
 * @since : 08/03/2022 à 13:12:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportingInputDto {
    private ReportFormat reportFormat = ReportFormat.PDF;
    @NotNull
    private EReportType reportType;
    @Min(value = 1, message = "Le numero de la première page doit-être positif")
    private Integer page = 1;
    private Integer numeroExercice;
    private Long exerciceId;
    private Long previsionId;
    private String ville;
    private EtapeWorkflow etape;
    private Long structureId;
}
