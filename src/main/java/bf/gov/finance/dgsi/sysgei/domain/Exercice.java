
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

import java.time.LocalDate;

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
@Table(name = "exercice")
public class Exercice extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_exercice")
    @SequenceGenerator(name = "seq_app_exercice", sequenceName = "seq_app_exercice",
            initialValue = 1010, allocationSize = 5)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "annee", unique = true)
    private Integer annee;
    @Basic
    private LocalDate dateDebut;
    @Basic
    private LocalDate dateFin;
    @Basic
    private LocalDate dateClose;
    @Basic
    private Boolean current;

}
