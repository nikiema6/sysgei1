
package bf.gov.finance.dgsi.sysgei.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StructureDto extends AbstractAuditEntityDto {
    private Long id;
    private String libelleCourt;
    private String libelleLong;
    private String codeStruct;
    private Long localiteId;
    private String libelleLocalite;

}