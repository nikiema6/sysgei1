/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.repository;

import bf.gov.finance.dgsi.sysgei.domain.Workflow;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;

import java.util.Optional;

public interface WorkflowRepository extends AbstractRepository<Workflow, Long> {

    /**
     * Trouver le dernier workflot d'un l'inscription.
     * @param statut
     * @param previsionId
     * @return Optional<Workflow>
     */
    Optional<Workflow> findByStatutAndPrevisionIdAndDateFinIsNull(TypeStatut statut,
                                                                  Long previsionId);

}
