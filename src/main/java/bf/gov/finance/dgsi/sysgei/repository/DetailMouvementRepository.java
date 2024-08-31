/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.repository;

import bf.gov.finance.dgsi.sysgei.domain.DetailMouvement;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;

import java.util.List;

public interface DetailMouvementRepository extends AbstractRepository<DetailMouvement, Long> {

    /**
     * recuperation des detailMouvementId d'un mouvemen.
     *
     * @param statut
     * @param mouvementId
     * @return List<DetailMouvement>
     */
    List<DetailMouvement> findAllByStatutAndMouvementId(TypeStatut statut, Long mouvementId);

    /**
     * recuperation des DetailMouvement d'une Mouvement.
     *
     * @param statut
     * @param mouvementId
     * @param equipementId
     * @return List<DetailMouvemen>
     */
    List<DetailMouvement> findAllByStatutAndMouvementIdAndEquipementId(TypeStatut statut,
                                                                       Long mouvementId, Long equipementId);
}
