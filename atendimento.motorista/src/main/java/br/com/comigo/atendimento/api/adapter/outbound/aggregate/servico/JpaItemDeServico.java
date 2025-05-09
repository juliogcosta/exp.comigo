package br.com.comigo.atendimento.api.adapter.outbound.aggregate.servico;

import br.com.comigo.atendimento.api.domain.data.aggregate.servico.ItemDeServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_de_servico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaItemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private String unidadeMedida;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private JpaServico servico;

    public JpaItemDeServico(ItemDeServico itemDeServico) {
        this.nome = itemDeServico.getNome();
        this.descricao = itemDeServico.getDescricao();
        this.unidadeMedida = itemDeServico.getUnidadeMedida();
        this.servico = new JpaServico(itemDeServico.getServico());
    }
}