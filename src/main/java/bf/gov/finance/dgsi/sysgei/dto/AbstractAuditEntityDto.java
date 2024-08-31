/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.dto;


import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
@Data
public abstract class AbstractAuditEntityDto implements Serializable {
    @Enumerated(EnumType.STRING)
    private TypeStatut statut = TypeStatut.ACTIF;
    private String createdBy = "SYSGEI";
    private Instant createdDate = Instant.now();
    private String lastModifiedBy = "SYSGEI";
    private Instant lastModifiedDate  = Instant.now();

}
