/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ValeurPrevisionDto {
    private Long idExercice;
    private Long idStructure;
    private Long idPrevision;
    private Long idSousfamille;
    private String libelleStructure;
    private String libelleFamille;
    private String libelleSousFamille;
    private Integer valAnne0;
    private Integer valAnne1;
    private Integer valAnne2;
    private Integer total;
}
