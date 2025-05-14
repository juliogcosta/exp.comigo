package br.com.comigo.usuario.api.adapter.aggregate.prestador.outbound;

import br.com.comigo.usuario.api.domain.aggregate.prestador.SetupDeItemDoServico;
import br.com.comigo.usuario.api.domain.util.StatusDeSetupDeItemDoServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "setup_de_item_do_servico", schema = "atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaSetupDeItemDoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer precoUnitario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDeSetupDeItemDoServico status;

    @Column(nullable = false)
    private Long itemDeServicoId;

    @ManyToOne
    @JoinColumn(name = "prestador_id", nullable = false)
    private JpaPrestador prestador;

    public JpaSetupDeItemDoServico(SetupDeItemDoServico setupDeItemDoServico) {
        this.id = setupDeItemDoServico.getId();
        this.precoUnitario = setupDeItemDoServico.getPrecoUnitario();
        this.status = StatusDeSetupDeItemDoServico.ATIVO;
        this.itemDeServicoId = setupDeItemDoServico.getItemDeServicoId();
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", precoUnitario='" + getPrecoUnitario() + "'" +
                ", status='" + getStatus() + "'" +
                ", itemDeServicoId='" + getItemDeServicoId() + "'" +
                "}";
    }

}