package bf.gov.finance.dgsi.sysgei.dto;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class LocaliteDtoList {
    private final List<LocaliteDto> datas;
}
