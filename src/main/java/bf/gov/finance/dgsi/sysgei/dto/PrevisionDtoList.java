/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class PrevisionDtoList {
    private final List<PrevisionDto> datas;
}
