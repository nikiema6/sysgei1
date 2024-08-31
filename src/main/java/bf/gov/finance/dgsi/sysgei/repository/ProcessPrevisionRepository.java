/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.repository;

import bf.gov.finance.dgsi.sysgei.domain.ProcessPrevision;
import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeProcessPrev;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;

import java.util.Optional;

public interface ProcessPrevisionRepository extends AbstractRepository<ProcessPrevision, Long> {

    /**
     * Recuperer le process par etat.
     * @param statut
     * @param etat
     * @return Optional<ProcessPrevision>
     */
    Optional<ProcessPrevision> findByStatutAndEtatAndDateFinIsNull(TypeStatut statut, EtapeProcessPrev etat);
}
