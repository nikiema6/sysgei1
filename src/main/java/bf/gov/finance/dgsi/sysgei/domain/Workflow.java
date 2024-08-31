/*
 * Copyright (c) 2023 Mohamskab
 */

package bf.gov.finance.dgsi.sysgei.domain;

import bf.gov.finance.dgsi.sysgei.domain.enumm.EtapeWorkflow;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "workflow")
public class Workflow extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_worflow")
    @SequenceGenerator(name = "seq_workflow", sequenceName = "seq_flow",
            initialValue = 10001, allocationSize = 5)
    @EqualsAndHashCode.Include
    private Long id;
    @Basic
    private LocalDate dateDebut;
    @Basic
    private LocalDate dateFin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Prevision prevision;
    @Enumerated(EnumType.STRING)
    private EtapeWorkflow etapeWorkflow;
}
