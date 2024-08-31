package bf.gov.finance.dgsi.sysgei.dto;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class SousFamilleDtoList {
    private final List<SousFamilleDto> datas;
}
