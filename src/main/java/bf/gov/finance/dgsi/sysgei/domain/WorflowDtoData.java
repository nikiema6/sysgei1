/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.domain;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import bf.gov.finance.dgsi.sysgei.dto.PrevisionDto;
import lombok.Data;

import java.util.List;

@Data
public class WorflowDtoData {
    private List<PrevisionDto> previsionList;
    private EtapeWorkflow etapeWorkflow;
}
