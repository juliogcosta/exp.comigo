package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_de_servico_do_atendimento", schema = "atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaItemDeServicoDoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
   
    @Column(nullable = false)
    private Long setupDeItemDeServicoId;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = true)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "atendimento_id", nullable = false)
    private JpaAtendimento atendimento;
}