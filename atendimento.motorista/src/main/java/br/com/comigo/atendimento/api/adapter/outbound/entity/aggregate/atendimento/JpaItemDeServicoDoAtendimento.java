package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.atendimento;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_de_servico_do_atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaItemDeServicoDoAtendimento {
    private Long id;
    private Long setupDeItemDeServicoId;
    private Integer quantidade;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "atendimento_id", nullable = false)
    private JpaAtendimento atendimento;
}