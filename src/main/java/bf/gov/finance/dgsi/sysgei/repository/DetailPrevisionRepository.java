/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.repository;

import bf.gov.finance.dgsi.sysgei.domain.DetailPrevision;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;

import java.util.List;
import java.util.Optional;

public interface DetailPrevisionRepository extends AbstractRepository<DetailPrevision, Long> {

    /**
     * recuperation des detailPevision d'une prevision.
     * @param statut
     * @param previsionId
     * @return List<DetailPrevision>
     */
    List<DetailPrevision> findAllByStatutAndPrevisionId(TypeStatut statut, Long previsionId);

    /**
     * recuperation des detailPevision d'une prevision.
     * @param statut
     * @param previsionId
     * @param sousFamilleId
     * @return List<DetailPrevision>
     */
    List<DetailPrevision> findAllByStatutAndPrevisionIdAndSousFamilleId(TypeStatut statut,
                                                                        Long previsionId, Long sousFamilleId);

    /**
     * recuperation du detailPevision d'une année.
     * @param statut
     * @param previsionId
     * @param sousFamilleId
     * @param annee
     * @return List<DetailPrevision>
     */
    Optional<DetailPrevision> findAllByStatutAndPrevisionIdAndSousFamilleIdAndAnnee(TypeStatut statut,
                                                                                    Long previsionId,
                                                                                    Long sousFamilleId,
                                                                                    Integer annee);
}
