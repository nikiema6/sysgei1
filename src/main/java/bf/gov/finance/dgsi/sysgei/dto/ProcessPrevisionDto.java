/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeProcessPrev;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProcessPrevisionDto extends AbstractAuditEntityDto {
    private Long id;
    private String libelle;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private EtapeProcessPrev etat;
}
