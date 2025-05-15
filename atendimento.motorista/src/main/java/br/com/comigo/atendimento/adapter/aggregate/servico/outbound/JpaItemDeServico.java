package br.com.comigo.atendimento.adapter.aggregate.servico.outbound;

import br.com.comigo.atendimento.domain.aggregate.servico.ItemDeServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_de_servico", schema = "atendimento")
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
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", unidadeMedida='" + getUnidadeMedida() + "'" +
            "}";
    }

}