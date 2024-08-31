/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class ValeurPrevisionDtoList {
    private final List<ValeurPrevisionDto> datas;
}
