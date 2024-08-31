
package bf.gov.finance.dgsi.sysgei.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "prevision")
public class Prevision extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_prevision")
    @SequenceGenerator(name = "seq_app_prevision", sequenceName = "seq_app_prevision",
            initialValue = 1010, allocationSize = 5)
    @EqualsAndHashCode.Include
    private Long id;
    @Basic
    private String reference;
    private String designation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structure;
    @ManyToOne(fetch = FetchType.LAZY)
    private Exercice exercice;
}
