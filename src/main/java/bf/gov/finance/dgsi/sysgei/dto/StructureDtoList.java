package bf.gov.finance.dgsi.sysgei.dto;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class StructureDtoList {
    private final List<StructureDto> datas;
}
