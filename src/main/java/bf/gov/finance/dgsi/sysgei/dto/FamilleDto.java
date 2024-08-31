
/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author kaboremohamadi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class FamilleDto extends AbstractAuditEntityDto {
    private Long id;
    private String codeFamille;
    private String libelle;

}
