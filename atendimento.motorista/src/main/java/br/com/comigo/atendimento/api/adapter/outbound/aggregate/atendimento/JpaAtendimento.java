package br.com.comigo.atendimento.api.adapter.outbound.aggregate.atendimento;

import java.util.Date;

import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "prestador_id", nullable = false)
    private Long prestadorId;

    @Column(name = "setup_de_item_de_servico_id", nullable = false)
    private Long setupDeItemDeServicoId;

    @Column(name = "cliente_id", nullable = true)
    private Long clienteId;

    @Column
    private String clienteNome;

    @Embedded
    private JpaTelefone clienteTelefone;

    @Embedded
    private JpaTelefone clienteWhatsapp;

    @Column(name = "veiculo_id", nullable = true)
    private Long veiculoId;

    @Column
    private String veiculoPlaca;

    @Column(nullable = false)
    private String tipoOcorrencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDeAtendimento status;
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataHoraChamado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataHoraConfirmado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataHoraEmAndamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataHoraFinalizado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dataHoraCancelado;

    @Column(nullable = true)
    private String descricao;

    @Embedded
    private JpaEndereco base;

    @Embedded
    private JpaEndereco origem;

    @Embedded
    private JpaEndereco destino;
}