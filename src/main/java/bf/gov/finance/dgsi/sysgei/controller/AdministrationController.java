package bf.gov.finance.dgsi.sysgei.controller;

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
import bf.gov.finance.dgsi.sysgei.dto.ValeurPrevisionDtoList;
import bf.gov.finance.dgsi.sysgei.service.AdministrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 25/09/2023-16:14
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/sysgei/")
@SuppressWarnings("ALL")
public class AdministrationController {
    private final AdministrationService adminService;

    /**
     * Liste de Region.
     *
     * @return RegionList
     */
    @GetMapping("/region")
    public ResponseEntity<RegionDtoList> fecthRegion() {
        return new ResponseEntity<>(adminService.fetchRegion(), HttpStatus.OK);
    }

    /**
     * création d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    @PostMapping("/region")
    public ResponseEntity<RegionDto> createRegion(@RequestBody @Valid final RegionDto dto) {
        return new ResponseEntity<>(adminService.createRegion(dto), HttpStatus.CREATED);
    }


    /**
     * Update d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    @PutMapping("/region")
    public ResponseEntity<RegionDto> updateRegion(@RequestBody @Valid final RegionDto dto) {
        return new ResponseEntity<>(adminService.updateRegion(dto), HttpStatus.CREATED);
    }

    /**
     * Suppression d'un Region.
     *
     * @param id
     * @return RegionDto
     */
    @PatchMapping("/region/{id}")
    public ResponseEntity<RegionDto> deleteRegion(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteRegion(id), HttpStatus.OK);
    }

    /**
     * Enregistrement d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     */
    @PostMapping("/famille")
    public ResponseEntity<FamilleDto> createFamille(@RequestBody @Valid final FamilleDto familleDto) {
        return new ResponseEntity<>(adminService.createFamille(familleDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     */
    @PutMapping("/famille")
    public ResponseEntity<FamilleDto> updateFamille(@RequestBody @Valid final FamilleDto familleDto) {
        return new ResponseEntity<>(adminService.updateFamille(familleDto), HttpStatus.CREATED);
    }


    /**
     * Suppression logique d'une Famile d'équipement.
     *
     * @param id
     * @return FamilleDto
     */
    @PatchMapping("/famille/{id}")
    public ResponseEntity<FamilleDto> deleteFamille(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteFamille(id), HttpStatus.OK);
    }

    /**
     * Liste des famille d'équipement.
     *
     * @return FamilleDtoList
     */
    @GetMapping("/famille")
    public ResponseEntity<FamilleDtoList> fecthFamille() {
        return new ResponseEntity<>(adminService.fetchFamille(), HttpStatus.OK);
    }

    /**
     * Enregistrement d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     */
    @PostMapping("/sous-famille")
    public ResponseEntity<SousFamilleDto> createSousFamille(@RequestBody @Valid final SousFamilleDto sousFamilleDto) {
        return new ResponseEntity<>(adminService.createSousFamille(sousFamilleDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     */
    @PutMapping("/sous-famille")
    public ResponseEntity<SousFamilleDto> updateSousFamille(@RequestBody @Valid final SousFamilleDto sousFamilleDto) {
        return new ResponseEntity<>(adminService.updateSousFamille(sousFamilleDto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'une sous famile d'équipement.
     *
     * @param id
     * @return SousFamilleDto
     */
    @PatchMapping("/sous-famille/{id}")
    public ResponseEntity<SousFamilleDto> deletesousFamille(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteSousFamille(id), HttpStatus.OK);
    }

    /**
     * Liste des famille d'équipement.
     *
     * @return FamilleDtoList
     */
    @GetMapping("/sous-famille")
    public ResponseEntity<SousFamilleDtoList> fecthSousFamille() {
        return new ResponseEntity<>(adminService.fetchSousFamille(), HttpStatus.OK);
    }

    /**
     * Enregistrement d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     */
    @PostMapping("/province")
    public ResponseEntity<ProvinceDto> createProvince(@RequestBody @Valid final ProvinceDto provinceDto) {
        return new ResponseEntity<>(adminService.createProvince(provinceDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     */
    @PutMapping("/province")
    public ResponseEntity<ProvinceDto> updateProvince(@RequestBody @Valid final ProvinceDto provinceDto) {
        return new ResponseEntity<>(adminService.updateProvince(provinceDto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'une province.
     *
     * @param id
     * @return ProvinceDto
     */
    @PatchMapping("/province/{id}")
    public ResponseEntity<ProvinceDto> deleteProvince(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteProvince(id), HttpStatus.OK);
    }

    /**
     * Liste des provinces.
     *
     * @return ProvinceDtoList
     */
    @GetMapping("/province")
    public ResponseEntity<ProvinceDtoList> fecthProvince() {
        return new ResponseEntity<>(adminService.fetchProvince(), HttpStatus.OK);
    }

    /**
     * Enregistrement d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     */
    @PostMapping("/departement")
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody @Valid final DepartementDto departementDto) {
        return new ResponseEntity<>(adminService.createDepartement(departementDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     */
    @PutMapping("/departement")
    public ResponseEntity<DepartementDto> updateDepartement(@RequestBody @Valid final DepartementDto departementDto) {
        return new ResponseEntity<>(adminService.updateDepartement(departementDto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'un département.
     *
     * @param id
     * @return DepartementDto
     */
    @PatchMapping("/departement/{id}")
    public ResponseEntity<DepartementDto> deleteDepartement(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteDepartement(id), HttpStatus.OK);
    }

    /**
     * Liste des département.
     *
     * @return DepartementDtoList
     */
    @GetMapping("/departement")
    public ResponseEntity<DepartementDtoList> fecthDepartement() {
        return new ResponseEntity<>(adminService.fetchDepartement(), HttpStatus.OK);
    }

    /**
     * Enregistrement d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     */
    @PostMapping("/localite")
    public ResponseEntity<LocaliteDto> createLocalite(@RequestBody @Valid final LocaliteDto localiteDto) {
        return new ResponseEntity<>(adminService.createLocalite(localiteDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     */
    @PutMapping("/localite")
    public ResponseEntity<LocaliteDto> updateLocalite(@RequestBody @Valid final LocaliteDto localiteDto) {
        return new ResponseEntity<>(adminService.updateLocalite(localiteDto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'une localité.
     *
     * @param id
     * @return LocaliteDto
     */
    @PatchMapping("/localite/{id}")
    public ResponseEntity<LocaliteDto> deleteLocalite(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteLocalite(id), HttpStatus.OK);
    }

    /**
     * Liste des localite.
     *
     * @return LocaliteDtoList
     */
    @GetMapping("/localite")
    public ResponseEntity<LocaliteDtoList> fecthLocalite() {
        return new ResponseEntity<>(adminService.fetchLocalite(), HttpStatus.OK);
    }

    /**
     * Enregistrement d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     */
    @PostMapping("/exercice")
    public ResponseEntity<ExerciceDto> createExercice(@RequestBody @Valid final ExerciceDto exerciceDto) {
        return new ResponseEntity<>(adminService.createExercice(exerciceDto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     */
    @PutMapping("/exercice")
    public ResponseEntity<ExerciceDto> updateExercice(@RequestBody @Valid final ExerciceDto exerciceDto) {
        return new ResponseEntity<>(adminService.updateExercice(exerciceDto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'un exercice.
     *
     * @param id
     * @return ExerciceDto
     */
    @PatchMapping("/exercice/{id}")
    public ResponseEntity<ExerciceDto> deleteExercice(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteExercice(id), HttpStatus.OK);
    }

    /**
     * Liste des exercices.
     *
     * @return ExerciceDtoList
     */
    @GetMapping("/exercice")
    public ResponseEntity<ExerciceDtoList> fecthExercice() {
        return new ResponseEntity<>(adminService.fetchExercice(), HttpStatus.OK);
    }

    /**
     * Activate des exercices.
     *
     * @param dto
     * @return ResponseEntity<ExerciceDto>
     */
    @PostMapping("/exercice/active")
    public ResponseEntity<ExerciceDto> fecthExercice(@RequestBody @Valid final ExerciceDto dto) {
        return new ResponseEntity<>(adminService.activateExercice(dto), HttpStatus.OK);
    }

    /**
     * Enregistrement d'une caractéristique.
     *
     * @param dto
     * @return CaracteristiqueDto
     */
    @PostMapping("/caracteristique")
    public ResponseEntity<CaracteristiqueDto> createCaracterisituque(@RequestBody @Valid final CaracteristiqueDto dto) {
        return new ResponseEntity<>(adminService.createCaracteristique(dto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une caractéristique.
     *
     * @param dto
     * @return CaracteristiqueDto
     */
    @PutMapping("/caracteristique")
    public ResponseEntity<CaracteristiqueDto> updateCaracteristique(@RequestBody @Valid final CaracteristiqueDto dto) {
        return new ResponseEntity<>(adminService.updateCaracteristique(dto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'une caractéristique.
     *
     * @param id
     * @return CaracteristiqueDto
     */
    @PatchMapping("/caracteristique/{id}")
    public ResponseEntity<CaracteristiqueDto> deleteCaracteristique(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteCaracteristique(id), HttpStatus.OK);
    }

    /**
     * Liste des caractéristiques.
     *
     * @return CaracteristiqueDtoList
     */
    @GetMapping("/caracteristique")
    public ResponseEntity<CaracteristiqueDtoList> fecthCaracteristique() {
        return new ResponseEntity<>(adminService.fetchCaracteristique(), HttpStatus.OK);
    }


    /**
     * Enregistrement d'une structure administrative.
     *
     * @param dto
     * @return StructureDto
     */
    @PostMapping("/structure")
    public ResponseEntity<StructureDto> createStructure(@RequestBody @Valid final StructureDto dto) {
        return new ResponseEntity<>(adminService.createStructure(dto), HttpStatus.CREATED);
    }

    /**
     * Mise à jour d'une structure administrative.
     *
     * @param dto
     * @return StructureDto
     */
    @PutMapping("/structure")
    public ResponseEntity<StructureDto> updateExercice(@RequestBody @Valid final StructureDto dto) {
        return new ResponseEntity<>(adminService.updateStructure(dto), HttpStatus.CREATED);
    }

    /**
     * Suppression logique d'une structures administratives.
     *
     * @param id
     * @return StructureDto
     */
    @PatchMapping("/structure/{id}")
    public ResponseEntity<StructureDto> deleteStructure(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deleteStructure(id), HttpStatus.OK);
    }

    /**
     * Liste des structures administratives.
     *
     * @return StructureDtoList
     */
    @GetMapping("/structure")
    public ResponseEntity<StructureDtoList> fecthStructure() {
        return new ResponseEntity<>(adminService.fetchStructure(), HttpStatus.OK);
    }

    /**
     * Initialisation des SousFamille sur les années.
     *
     * @return List<ValeurPrevision>
     */
    @GetMapping("/sous-famille/init")
    public ResponseEntity<ValeurPrevisionDtoList> iniSousFamilleWithVal() {
        return new ResponseEntity<>(adminService.iniSousFamilleWithVal(), HttpStatus.OK);
    }

    /**
     * Création d'une previsison .
     *
     * @param dto
     * @return ResponseEntity<PrevisionDto>
     */
    @PostMapping("/prevision")
    public ResponseEntity<PrevisionDto> createPrevision(@RequestBody @Valid final PrevisionDto dto) {
        return new ResponseEntity<>(adminService.createPrevision(dto), HttpStatus.OK);
    }

    /**
     * Recupreration des prevision par annee .
     *
     * @param dto
     * @return ResponseEntity<PrevisionDtoList>
     */
    @GetMapping("/prevision")
    public ResponseEntity<PrevisionDtoList> fetchPrevision(@Valid final CritereDto dto) {
        return new ResponseEntity<>(adminService.fetchPrevision(dto), HttpStatus.OK);
    }

    /**
     * Recupreration des prevision par annee .
     *
     * @param dto
     * @return ResponseEntity<PrevisionDtoList>
     */
    @PatchMapping("/prevision/val")
    public ResponseEntity<ValeurPrevisionDtoList> initValPrevision(@RequestBody @Valid final PrevisionDto dto) {
        return new ResponseEntity<>(adminService.iniSousFamilleWithVal(dto), HttpStatus.OK);
    }

    /**
     * Update a prevision.
     *
     * @param dto
     * @return Prevision
     */
    @PutMapping("/prevision")
    public ResponseEntity<PrevisionDto> updatePrevision(@RequestBody @Valid final PrevisionDto dto) {
        return new ResponseEntity<>(adminService.updatePrevision(dto), HttpStatus.OK);
    }

    /**
     * delete a prevision.
     *
     * @param id
     * @return Prevision
     */
    @PatchMapping("/prevision/{id}")
    public ResponseEntity<PrevisionDto> deletePrevision(@PathVariable final Long id) {
        return new ResponseEntity<>(adminService.deletePrevision(id), HttpStatus.OK);
    }

    /**
     * delete a detailPrevision.
     *
     * @param sousFamilleId
     * @param previsionId
     * @return ResponseEntity<Boolean>
     */
    @DeleteMapping("/detail-prevision")
    public ResponseEntity<Boolean> deleteDetail(
            @RequestParam(value = "sousFamilleId") final Long sousFamilleId,
            @RequestParam(value = "previsionId") final Long previsionId) {
        return new ResponseEntity<>(adminService.deleteDetail(sousFamilleId, previsionId), HttpStatus.OK);
    }


    /**
     * Push worflow to an etape.
     *
     * @param worflowDtoData
     * @return ResponseEntity<List < PrevisionDto>>
     */
    @PutMapping("/prevision/suivant")
    public ResponseEntity<List<PrevisionDto>> pushPrevisionToEtapeWorkflow(
            @RequestBody @Valid final WorflowDtoData worflowDtoData) {
        return new ResponseEntity<>(adminService.pushPrevisionToEtapeWorkflow(worflowDtoData), HttpStatus.OK);
    }

    /**
     * Fetch a ProcessPrevisionDto.
     *
     * @return ProcessPrevisionDtoList
     */
    @GetMapping("/process")
    final ResponseEntity<ProcessPrevisionDtoList> fetchProcess() {
        return new ResponseEntity<>(adminService.fetchProcess(), HttpStatus.OK);
    }

    /**
     * Open a ProcessPrevisionDto.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    @PostMapping("/process")
    public ResponseEntity<ProcessPrevisionDto> opentNewProcess(@RequestBody @Valid final ProcessPrevisionDto dto) {
        return new ResponseEntity<>(adminService.opentNewProcess(dto), HttpStatus.OK);
    }

    /**
     * Annuler a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    @PutMapping("/process")
    public ResponseEntity<ProcessPrevisionDto> annulerProcess(@RequestBody @Valid final ProcessPrevisionDto dto) {
        return new ResponseEntity<>(adminService.annulerProcess(dto), HttpStatus.OK);
    }

    /**
     * close a ProcessPrevision.
     *
     * @param dto
     * @return ProcessPrevisionDto
     */
    @PatchMapping("/process")
    public ResponseEntity<ProcessPrevisionDto> closePrevision(@RequestBody @Valid final ProcessPrevisionDto dto) {
        return new ResponseEntity<>(adminService.closePrevision(dto), HttpStatus.OK);
    }

    /**
     * PRevision centralisation By criteria.
     *
     * @param dto
     * @return ResponseEntity<ValeurPrevisionDtoList>
     */
    @GetMapping("/prevision/centralisation")
    public ResponseEntity<ValeurPrevisionDtoList> closePrevision(@Valid final CritereDto dto) {
        return new ResponseEntity<>(adminService.builValByCriteria(dto), HttpStatus.OK);
    }

    /**
     * Création d'un mouvement.
     *
     * @param mouvementDto
     * @return ResponseEntity<MouvementDto>
     */
    @PostMapping("/mouvement")
    public ResponseEntity<MouvementDto> createMouvement(@RequestBody @Valid final MouvementDto mouvementDto) {
        MouvementDto createdMouvement = adminService.createMouvement(mouvementDto);
        return new ResponseEntity<>(createdMouvement, HttpStatus.CREATED);
    }

    /**
     * Suppression d'un mouvement.
     *
     * @param id L'identifiant du mouvement à supprimer.
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/mouvement/{id}")
    public ResponseEntity<Void> deleteMouvement(final @PathVariable Long id) {
        adminService.deleteMouvement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Update a mouvement.
     *
     * @param dto
     * @return MouvementDto
     */
    @PutMapping("/mouvement")
    public ResponseEntity<MouvementDto> updateMouvement(@RequestBody @Valid final MouvementDto dto) {
        return new ResponseEntity<>(adminService.updateMouvement(dto), HttpStatus.OK);
    }

    /**
     * Liste des mouvements.
     *
     * @return MouvementDtoList
     */
    @GetMapping("/mouvement")
    public ResponseEntity<MouvementDtoList> fetchMouvement() {
        try {
            MouvementDtoList mouvements = adminService.fetchMouvement();
            return new ResponseEntity<>(mouvements, HttpStatus.OK);
        } catch (Exception e) {
            // Log l'erreur
            log.error("Erreur lors de la récupération des mouvements", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * delete a detailPrevision.
     *
     * @param equipemenrId
     * @param mouvementId
     * @return ResponseEntity<Boolean>
     */
    @DeleteMapping("/detail-mouvement")
    public ResponseEntity<Boolean> deleteDetaill(
            @RequestParam(value = "equipementId") final Long equipemenrId,
            @RequestParam(value = " mouvementId") final Long mouvementId) {
        return new ResponseEntity<>(adminService.deleteDetaill(equipemenrId, mouvementId), HttpStatus.OK);
    }

    /**
     * Création d'un mouvement.
     *
     * @param detailMouvemenDto
     * @return ResponseEntity<DetailMouvementDto>
     */
    @PostMapping("detail-mouvement")
    public ResponseEntity<DetailMouvementDto> createDetailMouvement(
            @RequestBody @Valid final DetailMouvementDto detailMouvemenDto) {
        return new ResponseEntity<>(adminService.createDetailMouvement(detailMouvemenDto), HttpStatus.CREATED);
    }
/*
    @PostMapping("/create-detail-mouvement")
    public DetailMouvementDto createDetailMouvement(@RequestParam Long idAcquisition, @RequestParam Long idMouvement) {
        DetailMouvementDto detailMouvementDto = new DetailMouvementDto();
        detailMouvementDto.setIdAcquisition(idAcquisition);
        detailMouvementDto.setIdMouvement(idMouvement);

        return administrationClient.createDetailMouvement(detailMouvementDto);
    }*/
}
