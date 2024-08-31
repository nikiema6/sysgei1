/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkflowDto extends AbstractAuditEntityDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long previsionId;
    private EtapeWorkflow etapeWorkflow;
}
