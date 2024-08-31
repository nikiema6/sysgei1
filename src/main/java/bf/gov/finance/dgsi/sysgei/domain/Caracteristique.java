
package bf.gov.finance.dgsi.sysgei.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author : <a href="mohamskab@outlook.fr"> MOHAMADI KABORE </a>.
 * @version : 1.0
 * @since : 04/10/2023
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "caracteristique")
public class Caracteristique extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_caracteristique")
    @SequenceGenerator(name = "seq_app_caracteristique", sequenceName = "seq_app_caracteristique",
            initialValue = 1010, allocationSize = 5)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(unique = true)
    private String codeCaracteristique;
    @Basic
    private String libelle;

}
