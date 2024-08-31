package bf.gov.finance.dgsi.sysgei.api.impl;

import bf.gov.finance.dgsi.sysgei.api.IAdministrationClient;
import bf.gov.finance.dgsi.sysgei.domain.Caracteristique;
import bf.gov.finance.dgsi.sysgei.domain.Departement;
import bf.gov.finance.dgsi.sysgei.domain.DetailMouvement;
import bf.gov.finance.dgsi.sysgei.domain.DetailPrevision;
import bf.gov.finance.dgsi.sysgei.domain.Equipement;
import bf.gov.finance.dgsi.sysgei.domain.Exercice;
import bf.gov.finance.dgsi.sysgei.domain.Famille;
import bf.gov.finance.dgsi.sysgei.domain.Localite;
import bf.gov.finance.dgsi.sysgei.domain.Mouvement;
import bf.gov.finance.dgsi.sysgei.domain.Prevision;
import bf.gov.finance.dgsi.sysgei.domain.ProcessPrevision;
import bf.gov.finance.dgsi.sysgei.domain.Province;
import bf.gov.finance.dgsi.sysgei.domain.Region;
import bf.gov.finance.dgsi.sysgei.domain.SousFamille;
import bf.gov.finance.dgsi.sysgei.domain.Structure;
import bf.gov.finance.dgsi.sysgei.domain.WorflowDtoData;
import bf.gov.finance.dgsi.sysgei.domain.Workflow;
import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeProcessPrev;
import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import bf.gov.finance.dgsi.sysgei.domain.enumm.TypeStatut;
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
import bf.gov.finance.dgsi.sysgei.dto.ValeurMouvementDto;
import bf.gov.finance.dgsi.sysgei.dto.ValeurMouvementDtoList;
import bf.gov.finance.dgsi.sysgei.dto.ValeurPrevisionDto;
import bf.gov.finance.dgsi.sysgei.dto.ValeurPrevisionDtoList;
import bf.gov.finance.dgsi.sysgei.dto.WorkflowDto;
import bf.gov.finance.dgsi.sysgei.reporting.config.ReportConfigService;
import bf.gov.finance.dgsi.sysgei.reporting.config.ReportConstant;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingInputDto;
import bf.gov.finance.dgsi.sysgei.reporting.dto.ReportingResponseDto;
import bf.gov.finance.dgsi.sysgei.repository.CaracteristiqueRepository;
import bf.gov.finance.dgsi.sysgei.repository.DepartementRepository;
import bf.gov.finance.dgsi.sysgei.repository.DetailMouvementRepository;
import bf.gov.finance.dgsi.sysgei.repository.DetailPrevisionRepository;
import bf.gov.finance.dgsi.sysgei.repository.EquipementRepository;
import bf.gov.finance.dgsi.sysgei.repository.ExerciceRepository;
import bf.gov.finance.dgsi.sysgei.repository.FamilleRepository;
import bf.gov.finance.dgsi.sysgei.repository.LocaliteRepository;
import bf.gov.finance.dgsi.sysgei.repository.MouvementRepository;
import bf.gov.finance.dgsi.sysgei.repository.PrevisionRepository;
import bf.gov.finance.dgsi.sysgei.repository.ProcessPrevisionRepository;
import bf.gov.finance.dgsi.sysgei.repository.ProvinceRepository;
import bf.gov.finance.dgsi.sysgei.repository.RegionRepository;
import bf.gov.finance.dgsi.sysgei.repository.SousFamilleRepository;
import bf.gov.finance.dgsi.sysgei.repository.StructureRepository;
import bf.gov.finance.dgsi.sysgei.repository.WorkflowRepository;
import bf.gov.finance.dgsi.sysgei.utils.Utility;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.apache.commons.collections4.ListUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @param <T>
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 25/09/2022-16:14
 **/
@Component
@RequiredArgsConstructor
@Slf4j
public class AdministrationClientImpl<T> implements IAdministrationClient {
    private final Mapper mapper;
    private final ReportConfigService reportConfigService;
    private final RegionRepository regionRepository;
    private final FamilleRepository familleRepository;
    private final SousFamilleRepository sousFamilleRepository;
    private final ProvinceRepository provinceRepository;
    private final DepartementRepository departementRepository;
    private final LocaliteRepository localiteRepository;
    private final ExerciceRepository exerciceRepository;
    private final CaracteristiqueRepository caracteristiqueRepository;
    private final StructureRepository structureRepository;
    private final PrevisionRepository previsionRepository;
    private final DetailPrevisionRepository detailPrevisionRepository;
    private final WorkflowRepository workflowRepository;
    private final ProcessPrevisionRepository processPrevisionRepository;
    private final MouvementRepository mouvementRepository;
    private final EquipementRepository equipementRepository;
    private final DetailMouvementRepository detailMouvementRepository;


    /**
     * Basique parma.
     *
     * @param inputDto
     * @return HashMap
     */
    @Override
    public HashMap<String, ? super Object> basiqueParam(final ReportingInputDto inputDto) throws IOException {
        final HashMap<String, ? super Object> parameterMap = new HashMap<>();
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        parameterMap.put(ReportConstant.JASPER_PARAM_VILLE, inputDto.getVille());
        parameterMap.put(ReportConstant.JASPER_PARAM_DATE, date);
        parameterMap.put(ReportConstant.JASPER_PARAM_EXERCICE, inputDto.getNumeroExercice());
        return parameterMap;
    }

    /**
     * Service global de génération des reports.
     *
     * @param inputDto
     * @return ReportingResponseDto
     */
    public ReportingResponseDto generateReport(final ReportingInputDto inputDto) throws JRException, IOException {
        log.debug("Generating the reports type: " + inputDto.getReportType());
        ReportingResponseDto reportingResponseDto;
        switch (inputDto.getReportType()) {
            case DUMMY:
                reportingResponseDto = this.dummyReport(inputDto);
                break;
            case PREVISION_REPORT:
                reportingResponseDto = this.previsionReport(inputDto);
                break;
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun type de reports trouvé");
        }
        return reportingResponseDto;
    }

    /**
     * Test.
     *
     * @param inputDto
     * @return ReportingResponseDto
     * @throws JRException
     * @throws IOException
     */
    private ReportingResponseDto dummyReport(final ReportingInputDto inputDto) {
        try {
            return this.reportConfigService.buildReport(inputDto, null, this.basiqueParam(inputDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recuperation de la liste des region.
     *
     * @return RegionList
     */
    @Override
    public RegionDtoList fetchRegion() {
        List<RegionDto> regionDtos = regionRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(region -> mapper.map(region, RegionDto.class)).collect(Collectors.toList());
        return RegionDtoList.of(regionDtos);
    }

    /**
     * création d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    @Override
    public RegionDto createRegion(final RegionDto dto) {
        Region region = mapper.map(dto, Region.class);
        region = regionRepository.save(region);
        return mapper.map(region, RegionDto.class);
    }

    /**
     * Update d'un Region.
     *
     * @param dto
     * @return RegionDto
     */
    @Override
    public RegionDto updateRegion(final RegionDto dto) {
        Region region = mapper.map(dto, Region.class);
        region = regionRepository.save(region);
        return mapper.map(region, RegionDto.class);
    }

    /**
     * Suppression d'un Region.
     *
     * @param id
     * @return RegionDto
     */
    @Override
    public RegionDto deleteRegion(final Long id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        Region region = optionalRegion.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.CONFLICT,
                        "Aucune region avec l'id " + id + " trouvée "));
        region.setStatut(TypeStatut.INACTIF);
        region = regionRepository.save(region);
        return mapper.map(region, RegionDto.class);
    }

    /**
     * Enregistrement d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     **/
    @Override
    public FamilleDto createFamille(final FamilleDto familleDto) {
        Famille reponse = familleRepository.save(mapper.map(familleDto, Famille.class));
        return mapper.map(reponse, FamilleDto.class);
    }

    /**
     * Mise à jour d'une famille d'équipement.
     *
     * @param familleDto
     * @return FamilleDto
     **/
    @Override
    public FamilleDto updateFamille(final FamilleDto familleDto) {
        Optional<Famille> isFamille = familleRepository.findById(familleDto.getId());
        if (isFamille.isPresent()) {
            return mapper.map(familleRepository.save(mapper.map(familleDto, Famille.class)), FamilleDto.class);
        } else {
            Famille famille = isFamille.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune famille avec l'id " + familleDto.getId() + " trouvée "));
            return mapper.map(famille, FamilleDto.class);
        }
    }

    /**
     * Récupération de la liste de famille d'équipement.
     *
     * @return FamilleDtoList
     **/
    @Override
    public FamilleDtoList fetchFamille() {
        List<FamilleDto> familleList = familleRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(famille -> mapper.map(famille, FamilleDto.class)).collect(Collectors.toList());
        return FamilleDtoList.of(familleList);
    }

    /**
     * Suppression logique d'une famille d'équipement.
     *
     * @param id
     * @return FamilleDto
     **/
    @Override
    public FamilleDto deleteFamille(final Long id) {
        Optional<Famille> isFamille = familleRepository.findById(id);
        if (isFamille.isPresent()) {
            isFamille.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(familleRepository.save(isFamille.get()), FamilleDto.class);
        } else {
            Famille famille = isFamille.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune famille avec l'id " + id + " trouvée "));
            return mapper.map(famille, FamilleDto.class);
        }
    }

    /**
     * Enregistrement d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     **/
    @Override
    public SousFamilleDto createSousFamille(final SousFamilleDto sousFamilleDto) {
        SousFamille reponse = sousFamilleRepository.save(mapper.map(sousFamilleDto, SousFamille.class));
        return mapper.map(reponse, SousFamilleDto.class);
    }

    /**
     * Mise à jour d'une sous famille d'équipement.
     *
     * @param sousFamilleDto
     * @return SousFamilleDto
     **/
    @Override
    public SousFamilleDto updateSousFamilleDto(final SousFamilleDto sousFamilleDto) {
        Optional<SousFamille> isSsFamille = sousFamilleRepository.findById(sousFamilleDto.getId());
        if (isSsFamille.isPresent()) {
            return mapper.map(sousFamilleRepository.save(mapper.map(sousFamilleDto,
                    SousFamille.class)), SousFamilleDto.class);

        } else {
            SousFamille ssFamille = isSsFamille.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune sous famille avec l'id " + sousFamilleDto.getId() + " trouvée "));
            return mapper.map(ssFamille, SousFamilleDto.class);
        }
    }

    /**
     * Récupération de la liste de sous famille d'équipement.
     *
     * @return SousFamilleDtoList
     **/
    @Override
    public SousFamilleDtoList fetchSousFamille() {
        List<SousFamilleDto> sousfamilleList = sousFamilleRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(sousFamille -> mapper.map(sousFamille,
                        SousFamilleDto.class)).collect(Collectors.toList());
        return SousFamilleDtoList.of(sousfamilleList);
    }

    /**
     * Suppression logique d'une sous famille d'équipement.
     *
     * @param id
     * @return SousFamilleDto
     **/
    @Override
    public SousFamilleDto deleteSousFamille(final Long id) {
        Optional<SousFamille> isSsFamille = sousFamilleRepository.findById(id);
        if (isSsFamille.isPresent()) {
            isSsFamille.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(sousFamilleRepository.save(isSsFamille.get()), SousFamilleDto.class);
        } else {
            SousFamille ssFamille = isSsFamille.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune sous famille avec l'id " + id + " trouvée "));
            return mapper.map(ssFamille, SousFamilleDto.class);
        }
    }

    /**
     * Enregistrement d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     **/
    @Override
    public ProvinceDto createProvince(final ProvinceDto provinceDto) {
        Province reponse = provinceRepository.save(mapper.map(provinceDto, Province.class));
        return mapper.map(reponse, ProvinceDto.class);
    }

    /**
     * Mise à jour d'une province.
     *
     * @param provinceDto
     * @return ProvinceDto
     **/
    @Override
    public ProvinceDto updateProvince(final ProvinceDto provinceDto) {
        Optional<Province> isProvince = provinceRepository.findById(provinceDto.getId());
        if (isProvince.isPresent()) {
            return mapper.map(provinceRepository.save(mapper.map(provinceDto, Province.class)), ProvinceDto.class);
        } else {
            Province province = isProvince.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune province avec l'id " + provinceDto.getId() + " trouvée "));
            return mapper.map(province, ProvinceDto.class);
        }
    }


    /**
     * Récupération de la liste des provinces.
     *
     * @return ProvinceDtoList
     **/
    @Override
    public ProvinceDtoList fetchProvince() {
        List<ProvinceDto> provinceListe = provinceRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(province -> mapper.map(province, ProvinceDto.class)).collect(Collectors.toList());
        return ProvinceDtoList.of(provinceListe);
    }

    /**
     * Suppression logique d'une province.
     *
     * @param id
     * @return ProvinceDto
     **/
    @Override
    public ProvinceDto deleteProvince(final Long id) {
        Optional<Province> isProvince = provinceRepository.findById(id);
        if (isProvince.isPresent()) {
            isProvince.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(provinceRepository.save(isProvince.get()), ProvinceDto.class);
        } else {
            Province province = isProvince.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune province avec l'id " + id + " trouvée "));
            return mapper.map(province, ProvinceDto.class);
        }
    }

    /**
     * Enregistrement d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     **/
    @Override
    public DepartementDto createDepartement(final DepartementDto departementDto) {
        Departement reponse = departementRepository.save(mapper.map(departementDto, Departement.class));
        return mapper.map(reponse, DepartementDto.class);
    }

    /**
     * Mise à jour d'un département.
     *
     * @param departementDto
     * @return DepartementDto
     **/
    @Override
    public DepartementDto updateDepartement(final DepartementDto departementDto) {
        Optional<Departement> isDepartement = departementRepository.findById(departementDto.getId());
        if (isDepartement.isPresent()) {
            return mapper.map(departementRepository.save(mapper.map(departementDto, Departement.class)),
                    DepartementDto.class);
        } else {
            Departement departement = isDepartement.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucun département avec l'id " + departementDto.getId() + " trouvée "));
            return mapper.map(departement, DepartementDto.class);
        }
    }

    /**
     * Récupétation de la liste des departement.
     *
     * @return DepartementDtoList
     **/
    @Override
    public DepartementDtoList fetchDepartement() {
        List<DepartementDto> departementList = departementRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(departement -> mapper.map(departement, DepartementDto.class))
                .collect(Collectors.toList());
        return DepartementDtoList.of(departementList);
    }

    /**
     * Suppression logique d'un département.
     *
     * @param id
     * @return DepartementDto
     **/
    @Override
    public DepartementDto deleteDepartement(final Long id) {
        Optional<Departement> isDepartement = departementRepository.findById(id);
        if (isDepartement.isPresent()) {
            isDepartement.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(departementRepository.save(isDepartement.get()), DepartementDto.class);
        } else {
            Departement departement = isDepartement.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucun département avec l'id " + id + " trouvée "));
            return mapper.map(departement, DepartementDto.class);
        }
    }

    /**
     * Enregistrement d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     **/
    @Override
    public LocaliteDto createLocalite(final LocaliteDto localiteDto) {
        Localite reponse = localiteRepository.save(mapper.map(localiteDto, Localite.class));
        return mapper.map(reponse, LocaliteDto.class);
    }

    /**
     * Mise à jour d'une localité.
     *
     * @param localiteDto
     * @return LocaliteDto
     **/
    @Override
    public LocaliteDto updateLocalite(final LocaliteDto localiteDto) {
        Optional<Localite> isLocalite = localiteRepository.findById(localiteDto.getId());
        if (isLocalite.isPresent()) {
            return mapper.map(localiteRepository.save(mapper.map(localiteDto, Localite.class)), LocaliteDto.class);
        } else {
            Localite localite = isLocalite.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune localité avec l'id " + localiteDto.getId() + " trouvée "));
            return mapper.map(localite, LocaliteDto.class);
        }
    }

    /**
     * Récupétation de la liste des localité.
     *
     * @return LocaliteDtoList
     **/
    @Override
    public LocaliteDtoList fetchLocalite() {
        List<LocaliteDto> localiteList = localiteRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(localite -> mapper.map(localite, LocaliteDto.class)).collect(Collectors.toList());
        return LocaliteDtoList.of(localiteList);
    }

    /**
     * Suppression logique d'une localité.
     *
     * @param id
     * @return LocaliteDto
     **/
    @Override
    public LocaliteDto deleteLocalite(final Long id) {
        Optional<Localite> isLocalite = localiteRepository.findById(id);
        if (isLocalite.isPresent()) {
            isLocalite.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(localiteRepository.save(isLocalite.get()), LocaliteDto.class);
        } else {
            Localite localite = isLocalite.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune localité avec l'id " + id + " trouvée "));
            return mapper.map(localite, LocaliteDto.class);
        }
    }

    /**
     * Enregistrement d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     **/
    @Override
    public ExerciceDto createExercice(final ExerciceDto exerciceDto) {
        Exercice reponse = exerciceRepository.save(mapper.map(exerciceDto, Exercice.class));
        return mapper.map(reponse, ExerciceDto.class);
    }

    /**
     * Mise à jour d'un exercice.
     *
     * @param exerciceDto
     * @return ExerciceDto
     **/
    @Override
    public ExerciceDto updateExercice(final ExerciceDto exerciceDto) {
        Optional<Exercice> isExercice = exerciceRepository.findById(exerciceDto.getId());
        if (isExercice.isPresent()) {
            return mapper.map(exerciceRepository.save(mapper.map(exerciceDto, Exercice.class)), ExerciceDto.class);
        } else {
            Exercice exercice = isExercice.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucun exercice avec l'id " + exerciceDto.getId() + " trouvée "));
            return mapper.map(exercice, ExerciceDto.class);
        }
    }

    /**
     * Récupétatiosn de la liste des exercice.
     *
     * @return ExerciceDtoList
     **/
    @Override
    public ExerciceDtoList fetchExercice() {
        List<ExerciceDto> exerciceDtoList = exerciceRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(exercice -> mapper.map(exercice, ExerciceDto.class)).collect(Collectors.toList());
        return ExerciceDtoList.of(exerciceDtoList);
    }

    /**
     * Suppression logique d'un exercice.
     *
     * @param id
     * @return ExerciceDto
     **/
    @Override
    public ExerciceDto deleteExercice(final Long id) {
        Optional<Exercice> isExercice = exerciceRepository.findById(id);
        if (isExercice.isPresent()) {
            isExercice.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(exerciceRepository.save(isExercice.get()), ExerciceDto.class);
        } else {
            Exercice exercice = isExercice.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucun exercice avec l'id " + id + " trouvée "));
            return mapper.map(exercice, ExerciceDto.class);
        }
    }

    /**
     * Enregistrement d'une caracteristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     **/
    @Override
    public CaracteristiqueDto createCaracteristique(final CaracteristiqueDto caracteristiqueDto) {
        Caracteristique reponse = caracteristiqueRepository.save(mapper.map(caracteristiqueDto, Caracteristique.class));
        return mapper.map(reponse, CaracteristiqueDto.class);
    }

    /**
     * Mise à jour d'une caracteristique.
     *
     * @param caracteristiqueDto
     * @return CaracteristiqueDto
     **/
    @Override
    public CaracteristiqueDto updateCaracteristique(final CaracteristiqueDto caracteristiqueDto) {
        Optional<Caracteristique> isCaracteristique = caracteristiqueRepository.findById(caracteristiqueDto.getId());
        if (isCaracteristique.isPresent()) {
            return mapper.map(caracteristiqueRepository.save(mapper.map(caracteristiqueDto,
                    Caracteristique.class)), CaracteristiqueDto.class);
        } else {
            Caracteristique caracteristique = isCaracteristique.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune caractéristique avec l'id " + caracteristiqueDto.getId() + " trouvée "));
            return mapper.map(caracteristique, CaracteristiqueDto.class);
        }
    }

    /**
     * Récupétatiosn de la liste des caractéristiques des équipements.
     *
     * @return CaracteristiqueDtoList
     **/
    @Override
    public CaracteristiqueDtoList fetchCaracteristique() {
        List<CaracteristiqueDto> caracteristiqueDtoList = caracteristiqueRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(caracteristique -> mapper.map(caracteristique,
                        CaracteristiqueDto.class)).collect(Collectors.toList());
        return CaracteristiqueDtoList.of(caracteristiqueDtoList);
    }

    /**
     * Suppression logique d'une caractéristique.
     *
     * @param id
     * @return CaracteristiqueDto
     **/
    @Override
    public CaracteristiqueDto deleteCaracteristique(final Long id) {
        Optional<Caracteristique> isCaracteristique = caracteristiqueRepository.findById(id);
        if (isCaracteristique.isPresent()) {
            isCaracteristique.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(caracteristiqueRepository.save(isCaracteristique.get()), CaracteristiqueDto.class);
        } else {
            Caracteristique caracteristique = isCaracteristique.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune caractéristique avec l'id " + id + " trouvée "));
            return mapper.map(caracteristique, CaracteristiqueDto.class);
        }
    }

    /**
     * Enregistrement d'une structure.
     *
     * @param structureDto
     * @return StructureDto
     **/
    @Override
    public StructureDto createStructure(final StructureDto structureDto) {
        Structure reponse = structureRepository.save(mapper.map(structureDto, Structure.class));
        return mapper.map(reponse, StructureDto.class);
    }

    /**
     * Mise à jour d'une structure.
     *
     * @param structureDto
     * @return StructureDto
     **/
    @Override
    public StructureDto updateStructure(final StructureDto structureDto) {
        Optional<Structure> isStructure = structureRepository.findById(structureDto.getId());
        if (isStructure.isPresent()) {
            return mapper.map(structureRepository.save(mapper.map(structureDto, Structure.class)), StructureDto.class);
        } else {
            Structure structure = isStructure.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune structure avec l'id " + structureDto.getId() + " trouvée "));
            return mapper.map(structure, StructureDto.class);
        }
    }

    /**
     * Récupétatiosn de la liste des structures.
     *
     * @return StructureDtoList
     **/
    @Override
    public StructureDtoList fetchStructure() {
        List<StructureDto> structureDtoList = structureRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(structure -> mapper.map(structure, StructureDto.class)).collect(Collectors.toList());
        return StructureDtoList.of(structureDtoList);
    }

    /**
     * Suppression logique d'une structure.
     *
     * @param id
     * @return StructureDto
     **/
    @Override
    public StructureDto deleteStructure(final Long id) {
        Optional<Structure> isStructure = structureRepository.findById(id);
        if (isStructure.isPresent()) {
            isStructure.get().setStatut(TypeStatut.INACTIF);
            return mapper.map(structureRepository.save(isStructure.get()), StructureDto.class);
        } else {
            Structure structure = isStructure.orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.CONFLICT,
                            "Aucune structure avec l'id " + id + " trouvée "));
            return mapper.map(structure, StructureDto.class);
        }
    }

    /**
     * Initialisation des SousFamille.
     *
     * @return ValeurPrevisionDtoList
     */
    @Override
    public ValeurPrevisionDtoList iniSousFamilleWithVal() {
        List<ValeurPrevisionDto> valeurPrevisionDtos = new ArrayList<>();
        List<SousFamille> sousFamilles = sousFamilleRepository.findAllByStatut(TypeStatut.ACTIF);
        sousFamilles.forEach(sousFamille -> {
            ValeurPrevisionDto vPrevision = new ValeurPrevisionDto();
            vPrevision.setIdSousfamille(sousFamille.getId());
            vPrevision.setLibelleFamille(sousFamille.getFamille().getLibelle());
            vPrevision.setLibelleSousFamille(sousFamille.getLibelle());
            valeurPrevisionDtos.add(vPrevision);
        });
        return ValeurPrevisionDtoList.of(valeurPrevisionDtos);
    }

    /**
     * Generate numero de referencePrevision.
     *
     * @param exerciceId
     * @return String
     */
    public String generateReferencePrevision(final Long exerciceId) {
        Optional<Exercice> exerciceOptional = exerciceRepository.findById(exerciceId);
        if (exerciceOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aucun exercice trouve pour ce id " + exerciceId);
        }

        Optional<Prevision> optionalPrevision = previsionRepository
                .findFirstByExerciceIdOrderByReferenceDesc(exerciceId);

        if (optionalPrevision.isPresent()) {
            String num = optionalPrevision.get().getReference();
            return exerciceOptional.get().getAnnee() + "/" + Utility.generateSequenceNumber(num.split("/")[1]);
        } else {
            return exerciceOptional.get().getAnnee() + "/" + Utility.generateSequenceNumber("0");
        }
    }

    /**
     * Create a prevision.
     *
     * @return Prevision
     */
    @Override
    public PrevisionDto createPrevision(final PrevisionDto dto) {
        Prevision prevision = mapper.map(dto, Prevision.class);
        prevision.setReference(generateReferencePrevision(dto.getExerciceId()));
        prevision = previsionRepository.save(prevision);
        Prevision finalPrevision = prevision;

        if (!dto.getDetailPrevisions().isEmpty()) {
            List<DetailPrevision> detailPrevisions = dto.getDetailPrevisions()
                    .stream().flatMap(dp -> {
                        DetailPrevision d = mapper.map(dp, DetailPrevision.class);
                        d.setPrevision(finalPrevision);
                        return Stream.of(d);
                    }).collect(Collectors.toList());
            detailPrevisionRepository.saveAll(detailPrevisions);
        }
        workflowProcess(prevision, EtapeWorkflow.INIT);
        return mapper.map(prevision, PrevisionDto.class);
    }

    /**
     * fetch à prévisionDto.
     *
     * @param critere
     * @return PrevisionDtoList
     */
    @Override
    public PrevisionDtoList fetchPrevision(final CritereDto critere) {
        Stream<Prevision> previsionStream = previsionRepository
                .findAllByStatutAndExerciceId(TypeStatut.ACTIF, critere.getExerciceId());
        if (critere.getStructureId() != null) {
            previsionStream = previsionStream.filter(prevision -> (prevision.getStructure() != null
                    && prevision.getStructure().getId().equals(critere.getStructureId())));
        }

        if (critere.getEtape() != null) {
            previsionStream = previsionStream.filter(prevision -> {
                Optional<Workflow> workflow = findPrevisionLasWorkflow(prevision);
                return (workflow.isPresent()
                        && workflow.get().getEtapeWorkflow().equals(critere.getEtape()));
            });
        }

        return PrevisionDtoList.of(previsionStream.flatMap(prevision -> {
            PrevisionDto previsionDto = mapper.map(prevision, PrevisionDto.class);
            Optional<Workflow> workflow = findPrevisionLasWorkflow(prevision);
            workflow.ifPresent(wf -> previsionDto.setLastWorkflow(wf.getEtapeWorkflow()));
            return Stream.of(previsionDto);
        }).collect(Collectors.toList()));
    }

    /**
     * Initialisation des SousFamille sur les pour la modification.
     *
     * @param dto
     * @return List<ValeurPrevision>
     */
    @Override
    public ValeurPrevisionDtoList iniSousFamilleWithVal(final PrevisionDto dto) {
        Prevision prevision = mapper.map(dto, Prevision.class);
        List<ValeurPrevisionDto> valeurPrevisionDtos = buildValeurPrevisionDtos(prevision);
        return ValeurPrevisionDtoList.of(valeurPrevisionDtos);
    }

    /**
     * To buid the previsionDtoLit for any prevision.
     *
     * @param prev
     * @return List<ValeurPrevisionDto>
     */
    private List<ValeurPrevisionDto> buildValeurPrevisionDtos(final Prevision prev) {
        List<ValeurPrevisionDto> valeurPrevisionDtos;
        List<DetailPrevision> detailPrevisions = detailPrevisionRepository
                .findAllByStatutAndPrevisionId(TypeStatut.ACTIF, prev.getId())
                .stream().sorted(Comparator.comparing(detailPrevision ->
                        detailPrevision.getSousFamille().getId())).collect(Collectors.toList());
        List<List<DetailPrevision>> lists = ListUtils.partition(detailPrevisions, 3);
        valeurPrevisionDtos = lists.stream().flatMap(d -> {
            d = d.stream().sorted(Comparator.comparing(DetailPrevision::getAnnee))
                    .collect(Collectors.toList());
            Structure structure = structureRepository.findOneByStatutAndId(TypeStatut.ACTIF,
                    prev.getStructure().getId());

            ValeurPrevisionDto vp = new ValeurPrevisionDto();
            vp.setIdExercice(prev.getExercice().getId());
            vp.setIdStructure(prev.getStructure().getId());
            vp.setLibelleStructure(structure.getLibelleCourt()
                    .concat(" " + structure.getLibelleLong()));
            vp.setIdPrevision(prev.getId());
            vp.setIdSousfamille(d.get(0).getSousFamille().getId());
            vp.setLibelleSousFamille(d.get(0).getSousFamille().getLibelle());
            vp.setValAnne0(d.get(0).getQuantite());
            vp.setValAnne1(d.get(1).getQuantite());
            vp.setValAnne2(d.get(2).getQuantite());
            return Stream.of(vp);
        }).collect(Collectors.toList());
        return valeurPrevisionDtos;
    }

    /**
     * Update a prevision.
     *
     * @return PrevisionDto
     */
    @Override
    public PrevisionDto updatePrevision(final PrevisionDto dto) {
        Prevision prevision = mapper.map(dto, Prevision.class);
        prevision = previsionRepository.save(prevision);
        Prevision finalPrevision = prevision;
        if (!dto.getDetailPrevisions().isEmpty()) {
            List<DetailPrevision> detailPrevisions = dto.getDetailPrevisions()
                    .stream().flatMap(dp -> {
                        DetailPrevision d = mapper.map(dp, DetailPrevision.class);
                        Optional<DetailPrevision> oldPrevi = detailPrevisionRepository
                                .findAllByStatutAndPrevisionIdAndSousFamilleIdAndAnnee(TypeStatut.ACTIF, dto.getId(),
                                        dp.getSousFamilleId(), dp.getAnnee());
                        oldPrevi.ifPresent(detailPrevision -> d.setId(detailPrevision.getId()));
                        d.setPrevision(finalPrevision);
                        return Stream.of(d);
                    }).collect(Collectors.toList());
            detailPrevisionRepository.saveAll(detailPrevisions);
        }
        return mapper.map(prevision, PrevisionDto.class);
    }

    /**
     * delete a prevision.
     *
     * @param id
     * @return Prevision
     */
    @Override
    public PrevisionDto deletePrevision(final Long id) {
        Optional<Prevision> optionalPrevision = this.previsionRepository.findById(id);
        Prevision prevision = optionalPrevision.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.CONFLICT, "Aucune prevision trouver pour l'id " + id));
        prevision.setStatut(TypeStatut.INACTIF);
        prevision = previsionRepository.save(prevision);
        return mapper.map(prevision, PrevisionDto.class);
    }

    /**
     * delete a detailPrevision.
     *
     * @param idSousFamilleId
     * @param previsionId
     * @return Boolean
     */
    @Override
    public Boolean deleteDetail(final Long idSousFamilleId, final Long previsionId) {
        Optional<SousFamille> sousFamilleOptional = sousFamilleRepository.findById(idSousFamilleId);
        SousFamille sousFamille = sousFamilleOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.CONFLICT,
                        "Aucune sousfamille avec l'id " + idSousFamilleId + " trouvée "));
        List<DetailPrevision> detailPrevisions = detailPrevisionRepository
                .findAllByStatutAndPrevisionIdAndSousFamilleId(TypeStatut.ACTIF, previsionId, sousFamille.getId());
        detailPrevisionRepository.deleteAll(detailPrevisions);
        return Boolean.TRUE;
    }

    /**
     * Workflow process.
     *
     * @param etapeWorkflow
     * @param prevision
     */
    public void workflowProcess(final Prevision prevision, final EtapeWorkflow etapeWorkflow) {
        List<Workflow> workflowList = new ArrayList<>();
        Workflow workflowNew = new Workflow();
        Optional<Workflow> optionalWorkflow = findPrevisionLasWorkflow(prevision);
        if (optionalWorkflow.isPresent()) {
            Workflow workflow = optionalWorkflow.get();
            workflow.setDateFin(LocalDate.now());
            if (!workflow.getEtapeWorkflow().equals(etapeWorkflow)) {
                workflowList.add(workflow);
            }
        }
        // Création du nouveau workflow
        workflowNew.setEtapeWorkflow(etapeWorkflow);
        workflowNew.setDateDebut(LocalDate.now());
        workflowNew.setPrevision(prevision);
        workflowList.add(workflowNew);
        //To remove after
        List<WorkflowDto> workflowDtos = workflowList.stream().map(workflow ->
                mapper.map(workflow, WorkflowDto.class)).collect(Collectors.toList());
        workflowRepository.saveAll(workflowDtos.stream()
                .map(workflowDto -> mapper.map(workflowDto, Workflow.class))
                .collect(Collectors.toList()));
    }

    /**
     * Find InscriptionLastWorkFlow.
     *
     * @param prevision
     * @return Optional<Workflow>
     */
    public Optional<Workflow> findPrevisionLasWorkflow(final Prevision prevision) {
        return workflowRepository.findByStatutAndPrevisionIdAndDateFinIsNull(
                TypeStatut.ACTIF, prevision.getId()
        );
    }

    /**
     * Push worflow to an etape.
     *
     * @param worflowDtoData
     * @return Optional<Workflow>
     */
    public List<PrevisionDto> pushPrevisionToEtapeWorkflow(final WorflowDtoData worflowDtoData) {
        return worflowDtoData.getPrevisionList().stream().flatMap(dto -> {
            Prevision prevision = mapper.map(dto, Prevision.class);
            workflowProcess(prevision, worflowDtoData.getEtapeWorkflow());
            return Stream.of(dto);
        }).collect(Collectors.toList());
    }

    /**
     * Open a ProcessPrevisionDto.
     *
     * @param dto
     * @return Prevision
     */
    @Override
    public ProcessPrevisionDto opentNewProcess(final ProcessPrevisionDto dto) {
        ProcessPrevision pp;
        Optional<ProcessPrevision> processPrevision = processPrevisionRepository
                .findByStatutAndEtatAndDateFinIsNull(TypeStatut.ACTIF, EtapeProcessPrev.OUVERT);

        Optional<ProcessPrevision> processPrevisionClos = processPrevisionRepository
                .findByStatutAndEtatAndDateFinIsNull(TypeStatut.ACTIF, EtapeProcessPrev.FERMER);

        if (processPrevision.isEmpty()) {
            processPrevisionClos.ifPresent(p -> {
                p.setDateFin(LocalDate.now());
                processPrevisionRepository.save(p);
            });

            ProcessPrevision processPrev = mapper.map(dto, ProcessPrevision.class);
            processPrev.setEtat(EtapeProcessPrev.OUVERT);
            pp = processPrevisionRepository.save(processPrev);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Process de est déjà ouvert");
        }
        return mapper.map(pp, ProcessPrevisionDto.class);
    }

    /**
     * Annuler a ProcessPrevision.
     *
     * @param dto
     * @return Prevision
     */
    @Override
    public ProcessPrevisionDto annulerProcess(final ProcessPrevisionDto dto) {
        ProcessPrevision processPrevision = mapper.map(dto, ProcessPrevision.class);
        processPrevision.setStatut(TypeStatut.INACTIF);
        processPrevision = processPrevisionRepository.save(processPrevision);
        return mapper.map(processPrevision, ProcessPrevisionDto.class);
    }

    /**
     * close a ProcessPrevision.
     *
     * @param dto
     * @return Prevision
     */
    @Override
    public ProcessPrevisionDto closePrevision(final ProcessPrevisionDto dto) {
        ProcessPrevision pp;
        Optional<ProcessPrevision> processPrevisionOuv = processPrevisionRepository
                .findByStatutAndEtatAndDateFinIsNull(TypeStatut.ACTIF, EtapeProcessPrev.OUVERT);

        Optional<ProcessPrevision> processPrevisionClos = processPrevisionRepository
                .findByStatutAndEtatAndDateFinIsNull(TypeStatut.ACTIF, EtapeProcessPrev.FERMER);

        if (processPrevisionClos.isEmpty() && processPrevisionOuv.isPresent()) {
            processPrevisionOuv.ifPresent(processPrevision -> {
                processPrevision.setDateFin(LocalDate.now());
                processPrevisionRepository.save(processPrevision);
            });
            ProcessPrevision processPrev = mapper.map(dto, ProcessPrevision.class);
            processPrev.setEtat(EtapeProcessPrev.FERMER);
            pp = processPrevisionRepository.save(processPrev);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Le process est déjà fermé ");
        }
        return mapper.map(pp, ProcessPrevisionDto.class);
    }

    /**
     * Fetch a ProcessPrevisionDto.
     *
     * @return List<ProcessPrevisionDto>
     */
    @Override
    public ProcessPrevisionDtoList fetchProcess() {
        return ProcessPrevisionDtoList.of(processPrevisionRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(p -> mapper.map(p, ProcessPrevisionDto.class))
                .collect(Collectors.toList()));
    }

    /**
     * Prevision Centralisation by criteria.
     *
     * @param critere
     * @return ValeurPrevisionDtoList
     */
    public ValeurPrevisionDtoList builValByCriteria(final CritereDto critere) {
        List<ValeurPrevisionDto> valeurPrevisionDtos = new ArrayList<>();
        PrevisionDtoList previsionDtoList = fetchPrevision(critere);

        previsionDtoList.getDatas().forEach(prev -> {
            Prevision prevision = mapper.map(prev, Prevision.class);
            valeurPrevisionDtos.addAll(buildValeurPrevisionDtos(prevision));
        });

        return ValeurPrevisionDtoList.of(groupeByFamilleId(valeurPrevisionDtos));
    }

    /**
     * Group values by familleId and count quantite and by annee.
     *
     * @param list
     * @return List<ValeurPrevisionDto>
     */
    private List<ValeurPrevisionDto> groupeByFamilleId(final List<ValeurPrevisionDto> list) {
        List<ValeurPrevisionDto> valeurPrevisionDtos = new ArrayList<>();
        Map<Long, Integer[]> valeurPrevisionDtoMap = new HashMap<>();

        for (ValeurPrevisionDto vp : list) {
            Long sfId = vp.getIdSousfamille();
            Integer[] quantities = new Integer[] {vp.getValAnne0(), vp.getValAnne1(), vp.getValAnne2()};
            // Check if the product is already in the map
            if (valeurPrevisionDtoMap.containsKey(sfId)) {
                Integer[] currentQuantities = valeurPrevisionDtoMap.get(sfId);
                Integer[] newQtt = new Integer[] {
                        currentQuantities[0] + quantities[0],
                        currentQuantities[1] + quantities[1],
                        currentQuantities[2] + quantities[2]
                };
                valeurPrevisionDtoMap.put(sfId, newQtt);
            } else {
                // If it's not, add a new entry to the map
                valeurPrevisionDtoMap.put(sfId, quantities);
            }
        }
        valeurPrevisionDtoMap.forEach((aLong, integers) -> list.stream()
                .filter(v -> v.getIdSousfamille().equals(aLong)).findFirst()
                .ifPresent(v2 -> {
                    ValeurPrevisionDto vp = new ValeurPrevisionDto();
                    vp.setIdExercice(v2.getIdExercice());
                    vp.setIdStructure(v2.getIdStructure());
                    vp.setLibelleStructure(v2.getLibelleStructure());
                    vp.setIdPrevision(v2.getIdPrevision());
                    vp.setIdSousfamille(v2.getIdSousfamille());
                    vp.setLibelleSousFamille(v2.getLibelleSousFamille());
                    vp.setLibelleFamille(v2.getLibelleFamille());
                    vp.setValAnne0(integers[0]);
                    vp.setValAnne1(integers[1]);
                    vp.setValAnne2(integers[2]);
                    vp.setTotal(integers[0] + integers[1] + integers[2]);
                    valeurPrevisionDtos.add(vp);
                }));
        return valeurPrevisionDtos;
    }

    /**
     * generate prevision report.
     *
     * @param inputDto
     * @return ReportingResponseDto
     */
    private ReportingResponseDto previsionReport(final ReportingInputDto inputDto) throws IOException, JRException {
        Optional<Exercice> optionalExercice = exerciceRepository.findById(inputDto.getExerciceId());

        if (optionalExercice.isPresent()) {
            CritereDto critereDto = new CritereDto();
            critereDto.setEtape(inputDto.getEtape());
            critereDto.setExerciceId(inputDto.getExerciceId());
            critereDto.setStructureId(inputDto.getStructureId());

            List<ValeurPrevisionDto> dtos = builValByCriteria(critereDto)
                    .getDatas().stream()
                    .sorted(Comparator.comparing(ValeurPrevisionDto::getIdStructure))
                    .collect(Collectors.toList());

            HashMap<String, ? super Object> parameterMap = this.basiqueParam(inputDto);
            parameterMap.put("ANNEE_0", optionalExercice.get().getAnnee());
            parameterMap.put("ANNEE_1", optionalExercice.get().getAnnee() + 1);
            parameterMap.put("ANNEE_2", optionalExercice.get().getAnnee() + 2);
            return this.reportConfigService.buildReport(inputDto, dtos, parameterMap);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "L'execice avec ID " + inputDto.getExerciceId() + " est introuvable");
        }
    }

    /**
     * Activate exercice.
     *
     * @param dto
     * @return ExerciceDto
     */
    @Override
    public ExerciceDto activateExercice(final ExerciceDto dto) {
        // Todo implementer le processus d'activation d'un exercice.
        return null;
    }

    /**
     * Enregistrement d'un mouvement.
     *
     * @param mouvementDto
     **/
    @Override
    public MouvementDto createMouvement(final MouvementDto mouvementDto) {
        Mouvement mouvement = new Mouvement();
        mouvement.setTypeMouvement(mouvementDto.getTypeMouvement());
        mouvement.setMotif(mouvementDto.getMotif());
        if (mouvementDto.getStructureId() != null) {
            structureRepository.findById(mouvementDto.getStructureId())
                    .ifPresent(mouvement::setStructure);
        }
        return mapper.map(mouvementRepository.save(mouvement), MouvementDto.class);
    }

    /**
     * Récupération de la liste des mouvements.
     *
     * @return MouvementDtoList
     **/
    @Override
    public MouvementDtoList fetchMouvement() {
        List<MouvementDto> mouvementList = mouvementRepository.findAllByStatut(TypeStatut.ACTIF)
                .stream().map(mouvement -> mapper.map(mouvement, MouvementDto.class)).collect(Collectors.toList());
        return MouvementDtoList.of(mouvementList);
    }

    /**
     * Mise à jour d'un mouvement.
     *
     * @param mouvementDto L'objet DTO contenant les données du mouvement à mettre à jour.
     * @return MouvementDto L'objet mis à jour.
     **/
    @Override
    public MouvementDto updateMouvement(final MouvementDto mouvementDto) {
        // Recherche du mouvement existant par ID
        Mouvement existingMouvement = mouvementRepository.findById(mouvementDto.getId())
                .orElseThrow(() -> new RuntimeException("Mouvement non trouvé avec l'ID : " + mouvementDto.getId()));

        // Mise à jour des propriétés du mouvement
        existingMouvement.setTypeMouvement(mouvementDto.getTypeMouvement());
        existingMouvement.setMotif(mouvementDto.getMotif());

        if (mouvementDto.getStructureId() != null) {
            structureRepository.findById(mouvementDto.getStructureId())
                    .ifPresent(existingMouvement::setStructure);
        }

        // Sauvegarde du mouvement mis à jour et retour du DTO
        return mapper.map(mouvementRepository.save(existingMouvement), MouvementDto.class);
    }

    /**
     * Suppression logique d'un mouvement.
     *
     * @param id L'identifiant du mouvement à supprimer.
     * @return MouvementDto L'objet du mouvement mis à jour.
     **/
    @Override
    public MouvementDto deleteMouvement(final Long id) {
        Optional<Mouvement> isMouvement = mouvementRepository.findById(id);

        if (isMouvement.isPresent()) {
            // Met à jour le statut du mouvement à INACTIF
            isMouvement.get().setStatut(TypeStatut.INACTIF);

            // Sauvegarde le mouvement mis à jour
            Mouvement updatedMouvement = mouvementRepository.save(isMouvement.get());

            // Retourne le DTO du mouvement mis à jour
            return mapper.map(updatedMouvement, MouvementDto.class);
        } else {
            // Lève une exception si le mouvement n'existe pas
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Aucun mouvement avec l'id " + id + " trouvé.");
        }
    }


    /**
     * Delete a detailMouvement.
     *
     * @param idEquipementId
     * @param mouvementId
     * @return Boolean
     */
    @Override
    public Boolean deleteDetaill(final Long idEquipementId, final Long mouvementId) {
        Optional<Equipement> equipementOptional = equipementRepository.findById(idEquipementId);
        Equipement equipement = equipementOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.CONFLICT,
                        "Aucun équipement avec l'id " + idEquipementId + " trouvé "));
        List<DetailMouvement> detailMouvements = detailMouvementRepository
                .findAllByStatutAndMouvementIdAndEquipementId(TypeStatut.ACTIF, mouvementId, equipement.getId());
        detailMouvementRepository.deleteAll(detailMouvements);
        return Boolean.TRUE;
    }

    /**
     * Initialisation des Equipementsur les pour la modification.
     *
     * @param dto
     * @return List<ValeurMouvement>
     */
    @Override
    public ValeurMouvementDtoList iniEquipementWithVal(final MouvementDto dto) {
        Mouvement mouvement = mapper.map(dto, Mouvement.class);
        List<ValeurMouvementDto> valeurMouvementDtos = buildValeurMouvementDtos(mouvement);
        return ValeurMouvementDtoList.of(valeurMouvementDtos);
    }

    /**
     * To build the valeurMouvementDtoList for any mouvement.
     *
     * @param mouvement
     * @return List<ValeurMouvementDto>
     */
    private List<ValeurMouvementDto> buildValeurMouvementDtos(final Mouvement mouvement) {
        List<ValeurMouvementDto> valeurMouvementDtos;
        List<DetailMouvement> detailMouvements = detailMouvementRepository
                .findAllByStatutAndMouvementId(TypeStatut.ACTIF, mouvement.getId())
                .stream().sorted(Comparator.comparing(detailMouvement ->
                        detailMouvement.getEquipement().getId())).collect(Collectors.toList());

        valeurMouvementDtos = detailMouvements.stream().map(detailMouvement -> {
            Equipement equipement = equipementRepository.findOneByStatutAndId(TypeStatut.ACTIF,
                    detailMouvement.getEquipement().getId());

            ValeurMouvementDto vm = new ValeurMouvementDto();
            vm.setIdMouvement(mouvement.getId());
            vm.setIdEquipement(detailMouvement.getEquipement().getId());
            return vm;
        }).collect(Collectors.toList());

        return valeurMouvementDtos;
    }

    /**
     * Initialisation des Equipement.
     *
     * @return ValeurMouvementDtoList
     */
    @Override
    public ValeurMouvementDtoList iniEquipementWithVal() {
        List<ValeurMouvementDto> valeurMouvementDtos = new ArrayList<>();
        List<Equipement> equipements = equipementRepository.findAllByStatut(TypeStatut.ACTIF);
        equipements.forEach(equipement -> {
            ValeurMouvementDto vMouvement = new ValeurMouvementDto();
            vMouvement.setIdEquipement(equipement.getId());
            valeurMouvementDtos.add(vMouvement);
        });
        return ValeurMouvementDtoList.of(valeurMouvementDtos);
    }
    
    /**
     * Récupère tous les équipements.
     *
     * @return List<Equipement> La liste des équipements disponibles.
     */
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll(); // Récupère tous les équipements de la base de données
    }

    /* *//**
     *
     * @param detailMouvementDto
     * @return
     *//*
    @Override
    public DetailMouvementDto createDetailMouvement(final DetailMouvementDto detailMouvementDto) {
        // Récupérer l'ID d'acquisition
        Long idAcquisition = detailMouvementDto.getIdAcquisition();

        // Récupérer les matériels acquis
        Acquisition acquisition = acquisitionRepository.findById(idAcquisition).orElse(null);
        if (acquisition != null) {
            List<Equipement> equipements = acquisition.getEquipements();
            detailMouvementDto.setEquipements(equipements);
        }

        // Récupérer l'ID du mouvement
        Long idMouvement = detailMouvementDto.getIdMouvement();
        Mouvement mouvement = mouvementRepository.findById(idMouvement).orElse(null);

        // Créer un objet DetailMouvementDto et l'initialiser
        DetailMouvement detailMouvement = new DetailMouvement();
        detailMouvement.setIdAcquisition(idAcquisition);
        detailMouvement.setEquipements(equipements);
        detailMouvement.setIdMouvement(idMouvement);

        // Enregistrer le détail du mouvement
        detailMouvementRepository.save(detailMouvement);

        return detailMouvementDto;
    }*/
}
