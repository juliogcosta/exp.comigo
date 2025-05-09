package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.prestador;

import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDeServico;
import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDeServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "setup_de_item_de_servico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaSetupDeItemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer precoUnitario;

    @Column(nullable = false)
    private StatusDeSetupDeItemDeServico status;

    @Column(nullable = false)
    private Long itemDeServicoId;

    @ManyToOne
    @JoinColumn(name = "prestador_id", nullable = false)
    private JpaPrestador prestador;

    public JpaSetupDeItemDeServico(SetupDeItemDeServico setupDeItemDeServico) {
        this.id = setupDeItemDeServico.getId();
        this.precoUnitario = setupDeItemDeServico.getPrecoUnitario();
        this.status = setupDeItemDeServico.getStatus();
        this.itemDeServicoId = setupDeItemDeServico.getItemDeServicoId();
        this.prestador = new JpaPrestador(setupDeItemDeServico.getPrestador());
    }
}