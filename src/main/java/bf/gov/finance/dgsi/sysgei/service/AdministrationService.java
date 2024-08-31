package bf.gov.finance.dgsi.sysgei.service;

import bf.gov.finance.dgsi.sysgei.api.impl.AdministrationClientImpl;
import bf.gov.finance.dgsi.sysgei.domain.WorflowDtoData;
import bf.gov.finance.dgsi.sysgei.dto.CaracteristiqueDto;
import bf.gov.finance.dgsi.sysgei.dto.CaracteristiqueDtoList;
import bf.gov.finance.dgsi.sysgei.dto.CritereDto;
import bf.gov.finance.dgsi.sysgei.dto.DepartementDto;
import bf.gov.finance.dgsi.sysgei.dto.DepartementDtoList;
import bf.gov.finance.dgsi.sysgei.dto.DetailMouvementDto;
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
import bf.gov.finance.dgsi.sysgei.repository.EquipementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
@Slf4j
@Service
@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Transactional
public class AdministrationService {
    private final AdministrationClientImpl administrationClient;
    private final EquipementRepository equipementRepository;


    /**
     * Service global de génération des reports.
     *
     * @param inputDto
     * @return ReportingResponseDto
     */
    public ReportingResponseDto generateReport(final ReportingInputDto inputDto) throws JRException, IOException {
        return administrationClient.generateReport(inputDto);
    }

    /**
     * Basique parma.
     *
     * @param inputDto
     * @return HashMap
     * @throws IOException
     */
    public HashMap<String, ? super Object> basiqueParam(final ReportingInputDto inputDto) throws IOException {
        return administrationClient.basiqueParam(inputDto);
    }

    /**
     * recuperation de la liste des Region.
     *
     * @return RegionList
     */
    public RegionDtoList fetchRegion() {
        return administrationClient.fetchRegion();
    }

    /**
     * création d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    public RegionDto createRegion(final RegionDto dto) {
        return administrationClient.createRegion(dto);
    }


    /**
     * Update d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    public RegionDto updateRegion(final RegionDto dto) {
        return administrationClient.updateRegion(dto);
    }

    /**
     * Suppression d'un Region.
     *
     * @param id
     * @return RegionDto
     */
    public RegionDto deleteRegion(final Long id) {
        return administrationClient.deleteRegion(id);
    }


    /**
     * Enregitrement d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     */
    public FamilleDto createFamille(final FamilleDto familleDto) {
        return administrationClient.createFamille(familleDto);
    }

    /**
     * Mise à jour d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     */
    public FamilleDto updateFamille(final FamilleDto familleDto) {
        return administrationClient.updateFamille(familleDto);
    }

    /**
     * Suppression logique d'une famille d'équipement.
     *
     * @param id
     * @return FamilleDto
     */
    public FamilleDto deleteFamille(final Long id) {
        return administrationClient.deleteFamille(id);
    }

    /**
     * recuperation de la liste des familles d'équipement.
     *
     * @return FamilleListDto
     */
    public FamilleDtoList fetchFamille() {
        return administrationClient.fetchFamille();
    }

    /**
     * Enregitrement d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     */
    public SousFamilleDto createSousFamille(final SousFamilleDto sousFamilleDto) {
        return administrationClient.createSousFamille(sousFamilleDto);
    }

    /**
     * Mise à jour d'une famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     */
    public SousFamilleDto updateSousFamille(final SousFamilleDto sousFamilleDto) {
        return administrationClient.updateSousFamilleDto(sousFamilleDto);
    }

    /**
     * Suppression logique d'une sous famille d'équipement.
     *
     * @param id
     * @return SousFamilleDto
     */
    public SousFamilleDto deleteSousFamille(final Long id) {
        return administrationClient.deleteSousFamille(id);
    }

    /**
     * recuperation de la liste des sous familles d'équipement.
     *
     * @return SousFamilleListDtoList
     */
    public SousFamilleDtoList fetchSousFamille() {
        return administrationClient.fetchSousFamille();
    }

    /**
     * Enregitrement d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     */
    public ProvinceDto createProvince(final ProvinceDto provinceDto) {
        return administrationClient.createProvince(provinceDto);
    }

    /**
     * Mise à jour d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     */
    public ProvinceDto updateProvince(final ProvinceDto provinceDto) {
        return administrationClient.updateProvince(provinceDto);
    }

    /**
     * Suppression logique d'une province.
     *
     * @param id
     * @return ProvinceDto
     */
    public ProvinceDto deleteProvince(final Long id) {
        return administrationClient.deleteProvince(id);
    }

    /**
     * recuperation de la liste des province.
     *
     * @return ProvinceDtolist
     */
    public ProvinceDtoList fetchProvince() {
        return administrationClient.fetchProvince();
    }

    /**
     * Enregitrement d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     */
    public DepartementDto createDepartement(final DepartementDto departementDto) {
        return administrationClient.createDepartement(departementDto);
    }

    /**
     * Mise à jour d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     */
    public DepartementDto updateDepartement(final DepartementDto departementDto) {
        return administrationClient.updateDepartement(departementDto);
    }

    /**
     * Suppression logique d'une département.
     *
     * @param id
     * @return DepartementDto
     */
    public DepartementDto deleteDepartement(final Long id) {
        return administrationClient.deleteDepartement(id);
    }

    /**
     * recuperation de la liste des département.
     *
     * @return DepartementDtoList
     */
    public DepartementDtoList fetchDepartement() {
        return administrationClient.fetchDepartement();
    }

    /**
     * Enregitrement d'une localite.
     *
     * @param localiteDto
     * @return LocaliteDto
     */
    public LocaliteDto createLocalite(final LocaliteDto localiteDto) {
        return administrationClient.createLocalite(localiteDto);
    }

    /**
     * Mise à jour d'une localite.
     *
     * @param localiteDto
     * @return LocaliteDto
     */
    public LocaliteDto updateLocalite(final LocaliteDto localiteDto) {
        return administrationClient.updateLocalite(localiteDto);
    }

    /**
     * Suppression logique d'une localite.
     *
     * @param id
     * @return LocaliteDto
     */
    public LocaliteDto deleteLocalite(final Long id) {
        return administrationClient.deleteLocalite(id);
    }

    /**
     * recuperation de la liste des localite.
     *
     * @return LocaliteDtoList
     */
    public LocaliteDtoList fetchLocalite() {
        return administrationClient.fetchLocalite();
    }

    /**
     * Enregitrement d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     */
    public ExerciceDto createExercice(final ExerciceDto exerciceDto) {
        return administrationClient.createExercice(exerciceDto);
    }

    /**
     * Mise à jour d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     */
    public ExerciceDto updateExercice(final ExerciceDto exerciceDto) {
        return administrationClient.updateExercice(exerciceDto);
    }

    /**
     * Suppression logique d'un exercice.
     *
     * @param id
     * @return ExerciceDto
     */
    public ExerciceDto deleteExercice(final Long id) {
        return administrationClient.deleteExercice(id);
    }

    /**
     * recuperation de la liste des exercice.
     *
     * @return ExerciceDtoList
     */
    public ExerciceDtoList fetchExercice() {
        return administrationClient.fetchExercice();
    }

    /**
     * Enregitrement d'une caracteristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     */
    public CaracteristiqueDto createCaracteristique(final CaracteristiqueDto caracteristiqueDto) {
        return administrationClient.createCaracteristique(caracteristiqueDto);
    }

    /**
     * Mise à jour d'une caractéristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     */
    public CaracteristiqueDto updateCaracteristique(final CaracteristiqueDto caracteristiqueDto) {
        return administrationClient.updateCaracteristique(caracteristiqueDto);
    }

    /**
     * Suppression logique d'une caracteristique.
     *
     * @param id
     * @return CaracteristiqueDto
     */
    public CaracteristiqueDto deleteCaracteristique(final Long id) {
        return administrationClient.deleteCaracteristique(id);
    }

    /**
     * recuperation de la liste des caractéristiques.
     *
     * @return CaracteristiqueDtoList
     */
    public CaracteristiqueDtoList fetchCaracteristique() {
        return administrationClient.fetchCaracteristique();
    }

    /**
     * Enregitrement d'une structure administrative.
     *
     * @param structureDto
     * @return StructureDto
     */
    public StructureDto createStructure(final StructureDto structureDto) {
        return administrationClient.createStructure(structureDto);
    }

    /**
     * Mise à jour d'une structure administrative.
     *
     * @param structureDto
     * @return StructureDto
     */
    public StructureDto updateStructure(final StructureDto structureDto) {
        return administrationClient.updateStructure(structureDto);
    }

    /**
     * Suppression logique d'une structure administrative.
     *
     * @param id
     * @return StructureDto
     */
    public StructureDto deleteStructure(final Long id) {
        return administrationClient.deleteStructure(id);
    }

    /**
     * recuperation de la liste des structure administrative.
     *
     * @return StructureDtoList
     */
    public StructureDtoList fetchStructure() {
        return administrationClient.fetchStructure();
    }

    /**
     * Initialisation des SousFamille.
     *
     * @return ValeurPrevisionDtoList
     */
    public ValeurPrevisionDtoList iniSousFamilleWithVal() {
        return administrationClient.iniSousFamilleWithVal();
    }

    /**
     * Create a prevision.
     *
     * @param dto
     * @return Prevision
     */
    public PrevisionDto createPrevision(final PrevisionDto dto) {
        return administrationClient.createPrevision(dto);
    }

    /**
     * fetch à prévisionDto.
     *
     * @param critere
     * @return PrevisionDtoList
     */
    public PrevisionDtoList fetchPrevision(final CritereDto critere) {
        return administrationClient.fetchPrevision(critere);
    }

    /**
     * Initialisation des valeur SousFamille pour la la modification.
     *
     * @param dto
     * @return ValeurPrevisionDtoList
     */
    public ValeurPrevisionDtoList iniSousFamilleWithVal(final PrevisionDto dto) {
        return administrationClient.iniSousFamilleWithVal(dto);
    }

    /**
     * Update a prevision.
     *
     * @param dto
     * @return Prevision
     */
    public PrevisionDto updatePrevision(final PrevisionDto dto) {
        return administrationClient.updatePrevision(dto);
    }

    /**
     * delete a prevision.
     *
     * @param id
     * @return Prevision
     */
    public PrevisionDto deletePrevision(final Long id) {
        return administrationClient.deletePrevision(id);
    }

    /**
     * delete a detailPrevision.
     *
     * @param idSousFamilleId
     * @param previsionId
     * @return Boolean
     */
    public Boolean deleteDetail(final Long idSousFamilleId, final Long previsionId) {
        return administrationClient.deleteDetail(idSousFamilleId, previsionId);
    }

    /**
     * Push worflow to an etape.
     *
     * @param worflowDtoData
     * @return List<PrevisionDto>
     */
    public List<PrevisionDto> pushPrevisionToEtapeWorkflow(final WorflowDtoData worflowDtoData) {
        return administrationClient.pushPrevisionToEtapeWorkflow(worflowDtoData);
    }

    /**
     * Fetch a ProcessPrevisionDto.
     *
     * @return ProcessPrevisionDtoList
     */
    public ProcessPrevisionDtoList fetchProcess() {
        return administrationClient.fetchProcess();
    }

    /**
     * Open a ProcessPrevisionDto.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    public ProcessPrevisionDto opentNewProcess(final ProcessPrevisionDto dto) {
        return administrationClient.opentNewProcess(dto);
    }

    /**
     * Annuler a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    public ProcessPrevisionDto annulerProcess(final ProcessPrevisionDto dto) {
        return administrationClient.annulerProcess(dto);
    }

    /**
     * close a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    public ProcessPrevisionDto closePrevision(final ProcessPrevisionDto dto) {
        return administrationClient.closePrevision(dto);
    }

    /**
     * Prevision Centralisation by criteria.
     *
     * @param critere
     * @return ValeurPrevisionDtoList
     */
    public ValeurPrevisionDtoList builValByCriteria(final CritereDto critere) {
        return administrationClient.builValByCriteria(critere);
    }

    /**
     * Activate exercice.
     *
     * @param dto
     * @return ExerciceDto
     */
    public ExerciceDto activateExercice(final ExerciceDto dto) {
        return administrationClient.activateExercice(dto);
    }

    /**
     * Récupération de la liste des mouvements.
     *
     * @return MouvementDtoList
     */
    public MouvementDtoList fetchMouvement() {
        return administrationClient.fetchMouvement();
    }

    /**
     * Enregistrement d'un mouvement.
     *
     * @param mouvementDto L'objet DTO contenant les informations du mouvement à créer.
     * @return MouvementDto L'objet du mouvement créé.
     */
    public MouvementDto createMouvement(final MouvementDto mouvementDto) {
        if (mouvementDto.getMotif() == null || mouvementDto.getTypeMouvement() == null) {
            throw new IllegalArgumentException("Les champs motif et typeMouvement ne peuvent pas être nuls");
        }
        return administrationClient.createMouvement(mouvementDto);
    }

    /**
     * Mise à jour d'un mouvement.
     *
     * @param mouvementDto L'objet contenant les données du mouvement à mettre à jour.
     * @return MouvementDto L'objet du mouvement mis à jour.
     */
    public MouvementDto updateMouvement(final MouvementDto mouvementDto) {
        return administrationClient.updateMouvement(mouvementDto);
    }

    /**
     * Suppression logique d'un mouvement.
     *
     * @param id L'identifiant du mouvement à supprimer.
     * @return MouvementDto L'objet du mouvement mis à jour.
     */
    public MouvementDto deleteMouvement(final Long id) {
        return administrationClient.deleteMouvement(id);
    }


    /**
     * Initialisation des valeur Equipement pour la la modification.
     *
     * @param dto
     * @return ValeurMouvementDtoList
     */
    public ValeurMouvementDtoList iniEquipementWithVal(final MouvementDto dto) {
        return administrationClient.iniEquipementWithVal(dto);
    }

    /**
     * delete a detailMouvement.
     *
     * @param idEquipementId
     * @param mouvementId
     * @return Boolean
     */
    public Boolean deleteDetaill(final Long idEquipementId, final Long mouvementId) {
        return administrationClient.deleteDetail(idEquipementId, mouvementId);
    }

    /**
     * Création d'un mouvement.
     *
     * @param detailMouvemenDto
     * @return ResponseEntity<DetailMouvementDto>
     */
    public DetailMouvementDto createDetailMouvement(DetailMouvementDto detailMouvemenDto) {
        return administrationClient.createDetailMouvement(detailMouvemenDto);
    }
}
