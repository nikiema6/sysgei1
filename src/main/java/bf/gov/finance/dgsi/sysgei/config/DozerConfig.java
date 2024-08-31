package bf.gov.finance.dgsi.sysgei.config;

import bf.gov.finance.dgsi.sysgei.domain.Departement;
import bf.gov.finance.dgsi.sysgei.domain.DetailMouvement;
import bf.gov.finance.dgsi.sysgei.domain.DetailPrevision;
import bf.gov.finance.dgsi.sysgei.domain.Equipement;
import bf.gov.finance.dgsi.sysgei.domain.Localite;
import bf.gov.finance.dgsi.sysgei.domain.Mouvement;
import bf.gov.finance.dgsi.sysgei.domain.Prevision;
import bf.gov.finance.dgsi.sysgei.domain.Province;
import bf.gov.finance.dgsi.sysgei.domain.SousFamille;
import bf.gov.finance.dgsi.sysgei.domain.Structure;
import bf.gov.finance.dgsi.sysgei.domain.Workflow;
import bf.gov.finance.dgsi.sysgei.dto.DepartementDto;
import bf.gov.finance.dgsi.sysgei.dto.DetailMouvementDto;
import bf.gov.finance.dgsi.sysgei.dto.DetailPrevisionDto;
import bf.gov.finance.dgsi.sysgei.dto.EquipementDto;
import bf.gov.finance.dgsi.sysgei.dto.LocaliteDto;
import bf.gov.finance.dgsi.sysgei.dto.MouvementDto;
import bf.gov.finance.dgsi.sysgei.dto.PrevisionDto;
import bf.gov.finance.dgsi.sysgei.dto.ProvinceDto;
import bf.gov.finance.dgsi.sysgei.dto.SousFamilleDto;
import bf.gov.finance.dgsi.sysgei.dto.StructureDto;
import bf.gov.finance.dgsi.sysgei.dto.WorkflowDto;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 25/09/2023-16:14
 **/
@Configuration
public class DozerConfig {
    private final BeanMappingBuilder builder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(StructureDto.class, Structure.class, TypeMappingOptions.mapNull(false))
                    .fields("localiteId", "localite.id")
                    .fields("libelleLocalite", "localite.libelle");
            mapping(LocaliteDto.class, Localite.class, TypeMappingOptions.mapNull(false))
                    .fields("departementId", "departement.id");
            mapping(ProvinceDto.class, Province.class, TypeMappingOptions.mapNull(false))
                    .fields("regionId", "region.id")
                    .fields("libelleRegion", "region.libelle");
            mapping(PrevisionDto.class, Prevision.class, TypeMappingOptions.mapNull(false))
                    .fields("structureId", "structure.id")
                    .fields("exerciceId", "exercice.id")
                    .fields("libelleStructure", "structure.libelleLong");
            mapping(DetailPrevisionDto.class, DetailPrevision.class, TypeMappingOptions.mapNull(false))
                    .fields("previsionId", "prevision.id")
                    .fields("sousFamilleId", "sousFamille.id");
            mapping(EquipementDto.class, Equipement.class, TypeMappingOptions.mapNull(false))
                    .fields("sousFamilleId", "sousFamille.id")
                    .fields("acquisitionId", "acquisition.id");
            mapping(MouvementDto.class, Mouvement.class, TypeMappingOptions.mapNull(false))
                    .fields("structureId", "structure.id");
            mapping(SousFamilleDto.class, SousFamille.class, TypeMappingOptions.mapNull(false))
                    .fields("familleId", "famille.id")
                    .fields("libelleFamille", "famille.libelle");
            mapping(DepartementDto.class, Departement.class, TypeMappingOptions.mapNull(false))
                    .fields("provinceId", "province.id");
            mapping(WorkflowDto.class, Workflow.class, TypeMappingOptions.mapNull(false))
                    .fields("previsionId", "prevision.id");
            mapping(DetailMouvementDto.class, DetailMouvement.class, TypeMappingOptions.mapNull(false))
                    .fields("mouvementId", "mouvement.id")
                    .fields("equipementId", "equipement.id");
        }
    };

    /**
     * builds the dozer mapper.
     *
     * @return Mapper
     */
    @Bean
    public Mapper buildDozerMapper() {
        return DozerBeanMapperBuilder.create()
                .withMappingBuilder(builder)
                .build();
    }
}
