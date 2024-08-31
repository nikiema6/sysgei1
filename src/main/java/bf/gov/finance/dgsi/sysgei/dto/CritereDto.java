/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;
import lombok.Data;
@Data
public class CritereDto {
    private Long exerciceId;
    private Long structureId;
    private TypeStatut statut;
    private EtapeWorkflow etape;
}
