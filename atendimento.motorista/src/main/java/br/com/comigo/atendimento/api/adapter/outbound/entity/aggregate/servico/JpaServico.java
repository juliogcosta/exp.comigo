package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.servico;

import br.com.comigo.atendimento.api.domain.aggregate.servico.Servico;
import br.com.comigo.atendimento.api.domain.util.StatusDeServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "servico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private StatusDeServico status;

    public JpaServico(Servico servico) {
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.descricao = servico.getDescricao();
        this.status = servico.getStatus();
    }
}