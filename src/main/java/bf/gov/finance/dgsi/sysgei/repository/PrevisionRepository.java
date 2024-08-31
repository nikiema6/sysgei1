/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.repository;

import bf.gov.finance.dgsi.sysgei.domain.Prevision;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
public interface PrevisionRepository extends AbstractRepository<Prevision, Long>, JpaSpecificationExecutor<Prevision> {
    /**
     * find last vente realiser effectuer.
     * @param exerciceId
     * @return Optional<Prevision>
     */
    Optional<Prevision> findFirstByExerciceIdOrderByReferenceDesc(Long exerciceId);

    /**
     * recuperation de la lise des prevision.
     * @param exerciceId
     * @param statut
     * @return Stream<Prevision>
     */
    Stream<Prevision> findAllByStatutAndExerciceId(TypeStatut statut, Long exerciceId);
}
