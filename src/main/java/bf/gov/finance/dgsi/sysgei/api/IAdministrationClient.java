package bf.gov.finance.dgsi.sysgei.api;

import bf.gov.finance.dgsi.sysgei.dto.CaracteristiqueDto;
import bf.gov.finance.dgsi.sysgei.dto.CaracteristiqueDtoList;
import bf.gov.finance.dgsi.sysgei.dto.CritereDto;
import bf.gov.finance.dgsi.sysgei.dto.DepartementDto;
import bf.gov.finance.dgsi.sysgei.dto.DepartementDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ExerciceDto;
import bf.gov.finance.dgsi.sysgei.dto.ExerciceDtoList;
import bf.gov.finance.dgsi.sysgei.dto.FamilleDto;
import bf.gov.finance.dgsi.sysgei.dto.FamilleDtoList;
import bf.gov.finance.dgsi.sysgei.dto.LocaliteDto;
import bf.gov.finance.dgsi.sysgei.dto.LocaliteDtoList;
import bf.gov.finance.dgsi.sysgei.dto.MouvementDto;
import bf.gov.finance.dgsi.sysgei.dto.MouvementDtoList;
import bf.gov.finance.dgsi.sysgei.dto.PrevisionDto;
import bf.gov.finance.dgsi.sysgei.dto.PrevisionDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ProcessPrevisionDto;
import bf.gov.finance.dgsi.sysgei.dto.ProcessPrevisionDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ProvinceDto;
import bf.gov.finance.dgsi.sysgei.dto.ProvinceDtoList;
import bf.gov.finance.dgsi.sysgei.dto.RegionDto;
import bf.gov.finance.dgsi.sysgei.dto.RegionDtoList;
import bf.gov.finance.dgsi.sysgei.dto.SousFamilleDto;
import bf.gov.finance.dgsi.sysgei.dto.SousFamilleDtoList;
import bf.gov.finance.dgsi.sysgei.dto.StructureDto;
import bf.gov.finance.dgsi.sysgei.dto.StructureDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ValeurMouvementDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ValeurPrevisionDtoList;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingInputDto;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingResponseDto;
import net.sf.jasperreports.engine.JRException;

import java.io.IOException;
import java.util.HashMap;


/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 25/09/2023-16:14
 **/
@SuppressWarnings("ALL")
public interface IAdministrationClient {

    /**
     * Service global de génération des reports.
     *
     * @param inputDto
     * @return ReportingResponseDto
     */
    ReportingResponseDto generateReport(ReportingInputDto inputDto) throws JRException, IOException;

    /**
     * Global parm.
     *
     * @param inputDto
     * @return HashMap
     */
    HashMap<String, ? super Object> basiqueParam(ReportingInputDto inputDto) throws IOException;

    /**
     * recuperation de la liste des Region.
     *
     * @return RegionList
     */
    RegionDtoList fetchRegion();

    /**
     * création d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    RegionDto createRegion(RegionDto dto);


    /**
     * Update d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    RegionDto updateRegion(RegionDto dto);

    /**
     * Suppression d'un Region.
     *
     * @param id
     * @return RegionDto
     */
    RegionDto deleteRegion(Long id);

    /**
     * Enregistrement d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     **/
    FamilleDto createFamille(FamilleDto familleDto);

    /**
     * Mise à jour d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     **/
    FamilleDto updateFamille(FamilleDto familleDto);

    /**
     * Récupétation de la liste de familles d'équipement.
     *
     * @return FamilleDtoList
     **/
    FamilleDtoList fetchFamille();

    /**
     * Suppression d'une famille d'équipement.
     *
     * @param id
     * @return FamilleDto
     **/
    FamilleDto deleteFamille(Long id);

    /**
     * Enregistrement d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     **/
    SousFamilleDto createSousFamille(SousFamilleDto sousFamilleDto);

    /**
     * Mise à jour d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     **/
    SousFamilleDto updateSousFamilleDto(SousFamilleDto sousFamilleDto);

    /**
     * Récupétation de la liste de sous familles d'équipement.
     *
     * @return SousFamilleDtoList
     **/
    SousFamilleDtoList fetchSousFamille();

    /**
     * Suppression d'une sous famille d'équipement.
     *
     * @param id
     * @return SousFamilleDto
     **/
    SousFamilleDto deleteSousFamille(Long id);

    /**
     * Enregistrement d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     **/
    ProvinceDto createProvince(ProvinceDto provinceDto);

    /**
     * Mise à jour d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     **/
    ProvinceDto updateProvince(ProvinceDto provinceDto);

    /**
     * Récupétation de la liste des provinces.
     *
     * @return ProvinceDtoList
     **/
    ProvinceDtoList fetchProvince();

    /**
     * Suppression logique d'une province.
     *
     * @param id
     * @return ProvinceDto
     **/
    ProvinceDto deleteProvince(Long id);

    /**
     * Enregistrement d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     **/
    DepartementDto createDepartement(DepartementDto departementDto);

    /**
     * Mise à jour d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     **/
    DepartementDto updateDepartement(DepartementDto departementDto);

    /**
     * Récupétation de la liste des departement.
     *
     * @return DepartementDtoList
     **/
    DepartementDtoList fetchDepartement();

    /**
     * Suppression logique d'un département.
     *
     * @param id
     * @return DepartementDto
     **/
    DepartementDto deleteDepartement(Long id);

    /**
     * Enregistrement d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     **/
    LocaliteDto createLocalite(LocaliteDto localiteDto);

    /**
     * Mise à jour d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     **/
    LocaliteDto updateLocalite(LocaliteDto localiteDto);

    /**
     * Récupétation de la liste des localités.
     *
     * @return LocaliteDtoList
     **/
    LocaliteDtoList fetchLocalite();

    /**
     * Suppression logique d'une localité.
     *
     * @param id
     * @return LocaliteDto
     **/
    LocaliteDto deleteLocalite(Long id);

    /**
     * Enregistrement d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     **/
    ExerciceDto createExercice(ExerciceDto exerciceDto);

    /**
     * Mise à jour d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     **/
    ExerciceDto updateExercice(ExerciceDto exerciceDto);

    /**
     * Récupétatiosn de la liste des exercice.
     *
     * @return ExerciceDtoList
     **/
    ExerciceDtoList fetchExercice();

    /**
     * Suppression logique d'un exercice.
     *
     * @param id
     * @return ExerciceDto
     **/
    ExerciceDto deleteExercice(Long id);

    /**
     * Enregistrement d'une caracteristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     **/
    CaracteristiqueDto createCaracteristique(CaracteristiqueDto caracteristiqueDto);

    /**
     * Mise à jour d'une caracteristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     **/
    CaracteristiqueDto updateCaracteristique(CaracteristiqueDto caracteristiqueDto);

    /**
     * Récupétatiosn de la liste des caractéristiques des équipements.
     *
     * @return CaracteristiqueDtoList
     **/
    CaracteristiqueDtoList fetchCaracteristique();

    /**
     * Suppression logique d'une caractéristique.
     *
     * @param id
     * @return CaracteristiqueDto
     **/
    CaracteristiqueDto deleteCaracteristique(Long id);

    /**
     * Enregistrement d'une structure.
     *
     * @param structureDto
     * @return StructureDto
     **/
    StructureDto createStructure(StructureDto structureDto);

    /**
     * Mise à jour d'une structure.
     *
     * @param structureDto
     * @return StructureDto
     **/
    StructureDto updateStructure(StructureDto structureDto);

    /**
     * Récupétatiosn de la liste des structures.
     *
     * @return StructureDtoList
     **/
    StructureDtoList fetchStructure();

    /**
     * Suppression logique d'une structure.
     *
     * @param id
     * @return StructureDto
     **/
    StructureDto deleteStructure(Long id);


    /**
     * Initialisation des SousFamille sur les années n, n+1, n+2.
     *
     * @return List<ValeurPrevision>
     */
    ValeurPrevisionDtoList iniSousFamilleWithVal();

    /**
     * Create a prevision.
     *
     * @param dto
     * @return Prevision
     */
    PrevisionDto createPrevision(PrevisionDto dto);

    /**
     * fetch à prévisionDto.
     *
     * @param critere
     * @return PrevisionDtoList
     */
    PrevisionDtoList fetchPrevision(CritereDto critere);

    /**
     * Initialisation des SousFamille sur les pour la modification.
     *
     * @param dto
     * @return List<ValeurPrevision>
     */
    ValeurPrevisionDtoList iniSousFamilleWithVal(PrevisionDto dto);

    /**
     * Update a prevision.
     *
     * @param dto
     * @return Prevision
     */
    PrevisionDto updatePrevision(PrevisionDto dto);

    /**
     * delete a prevision.
     *
     * @param id
     * @return Prevision
     */
    PrevisionDto deletePrevision(Long id);

    /**
     * delete a detailPrevision.
     *
     * @param idSousFamilleId
     * @param previsionId
     * @return Boolean
     */
    Boolean deleteDetail(Long idSousFamilleId, Long previsionId);

    /**
     * Fetch a ProcessPrevisionDto.
     *
     * @return ProcessPrevisionDtoList
     */
    ProcessPrevisionDtoList fetchProcess();

    /**
     * Open a ProcessPrevisionDto.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    ProcessPrevisionDto opentNewProcess(ProcessPrevisionDto dto);

    /**
     * Annuler a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    ProcessPrevisionDto annulerProcess(ProcessPrevisionDto dto);

    /**
     * close a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    ProcessPrevisionDto closePrevision(ProcessPrevisionDto dto);

    /**
     * Activate exercice.
     *
     * @param dto
     * @return ExerciceDto
     */
    ExerciceDto activateExercice(ExerciceDto dto);

    /**
     * Create a mouvement.
     *
     * @param mouvementDto
     * @return mouvement
     */
    MouvementDto createMouvement(MouvementDto mouvementDto);

    /**
     * Récupération de la liste des mouvements.
     *
     * @param
     * @return MouvementDtoList
     **/
    MouvementDtoList fetchMouvement();

    /**
     * Mise à jour d'un mouvement.
     *
     * @param mouvementDto
     * @return MouvementDto L'objet mis à jour.
     **/
    MouvementDto updateMouvement(MouvementDto mouvementDto);

    /**
     * Suppression logique d'un mouvement.
     *
     * @param id L'identifiant du mouvement à supprimer.
     * @return MouvementDto L'objet du mouvement mis à jour.
     **/
    MouvementDto deleteMouvement(Long id);

    /**
     * delete a detailPrevision.
     *
     * @param idEquipementId
     * @param mouvementId
     * @return Boolean
     */
    Boolean deleteDetaill(Long idEquipementId, Long mouvementId);


    /**
     * Initialisation des Equipementsur les pour la modification.
     *
     * @param dto
     * @return List<ValeurMouvement>
     */
    ValeurMouvementDtoList iniEquipementWithVal(MouvementDto dto);


    /**
     * Initialisation des Equipement.
     *
     * @return List<ValeurMouvement>
     */
    ValeurMouvementDtoList iniEquipementWithVal();

    /* *//**
     *  creattion
     * @param detailMouvementDto
     * @return
     *//*
    DetailMouvementDto createDetailMouvement(DetailMouvementDto detailMouvementDto);*/
}
