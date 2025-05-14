package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.comigo.atendimento.api.adapter.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.Atendimento;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atendimento", schema = "atendimento")
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

        @Column(name = "cliente_id", nullable = true)
        private Long clienteId;

        @Column
        private String clienteNome;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "numero", column = @Column(name = "cliente_telefone_numero")),
                @AttributeOverride(name = "tipo", column = @Column(name = "cliente_telefone_tipo"))
        })
        private JpaTelefone clienteTelefone;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "numero", column = @Column(name = "cliente_whatsapp_numero")),
                @AttributeOverride(name = "tipo", column = @Column(name = "cliente_whatsapp_tipo"))
        })
        private JpaTelefone clienteWhatsapp;

        @Column(name = "veiculo_id", nullable = true)
        private Long veiculoId;

        @Column
        private String veiculoPlaca;

        @Column(nullable = false)
        private String tipoOcorrencia;

        @Column(nullable = false)
        private String tipoServico;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private StatusDeAtendimento status;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(nullable = false)
        private Timestamp dataHoraChamado;

        @Temporal(TemporalType.TIMESTAMP)
        @Column
        private Timestamp dataHoraConfirmado;

        @Temporal(TemporalType.TIMESTAMP)
        @Column
        private Timestamp dataHoraEmAndamento;

        @Temporal(TemporalType.TIMESTAMP)
        @Column
        private Timestamp dataHoraFinalizado;

        @Temporal(TemporalType.TIMESTAMP)
        @Column
        private Timestamp dataHoraCancelado;

        @Column(nullable = true)
        private String descricao;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_base_logradouro")),
                @AttributeOverride(name = "numero", column = @Column(name = "endereco_base_numero")),
                @AttributeOverride(name = "complemento", column = @Column(name = "endereco_base_complemento")),
                @AttributeOverride(name = "bairro", column = @Column(name = "endereco_base_bairro")),
                @AttributeOverride(name = "cidade", column = @Column(name = "endereco_base_cidade")),
                @AttributeOverride(name = "estado", column = @Column(name = "endereco_base_estado")),
                @AttributeOverride(name = "cep", column = @Column(name = "endereco_base_cep"))
        })
        private JpaEndereco base;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_origem_logradouro")),
                @AttributeOverride(name = "numero", column = @Column(name = "endereco_origem_numero")),
                @AttributeOverride(name = "complemento", column = @Column(name = "endereco_origem_complemento")),
                @AttributeOverride(name = "bairro", column = @Column(name = "endereco_origem_bairro")),
                @AttributeOverride(name = "cidade", column = @Column(name = "endereco_origem_cidade")),
                @AttributeOverride(name = "estado", column = @Column(name = "endereco_origem_estado")),
                @AttributeOverride(name = "cep", column = @Column(name = "endereco_origem_cep"))
        })
        private JpaEndereco origem;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "logradouro", column = @Column(name = "endereco_destino_logradouro")),
                @AttributeOverride(name = "numero", column = @Column(name = "endereco_destino_numero")),
                @AttributeOverride(name = "complemento", column = @Column(name = "endereco_destino_complemento")),
                @AttributeOverride(name = "bairro", column = @Column(name = "endereco_destino_bairro")),
                @AttributeOverride(name = "cidade", column = @Column(name = "endereco_destino_cidade")),
                @AttributeOverride(name = "estado", column = @Column(name = "endereco_destino_estado")),
                @AttributeOverride(name = "cep", column = @Column(name = "endereco_destino_cep"))
        })
        private JpaEndereco destino;
        
        @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private List<JpaItemDeServicoDoAtendimento> itemDeServicoDoAtendimentos = new ArrayList<>();

        public JpaAtendimento(Atendimento atendimento) {
                this.id = atendimento.getId();
                this.prestadorId = atendimento.getPrestadorId();
                this.clienteId = atendimento.getClienteId();
                this.clienteNome = atendimento.getClienteNome();
                this.clienteTelefone = atendimento.getClienteTelefone() != null 
                        ? new JpaTelefone(atendimento.getClienteTelefone().numero(), atendimento.getClienteTelefone().tipo()) : null;
                this.clienteWhatsapp = atendimento.getClienteWhatsapp() != null 
                        ? new JpaTelefone(atendimento.getClienteWhatsapp().numero(), atendimento.getClienteWhatsapp().tipo()) : null;
                this.veiculoId = atendimento.getVeiculoId();
                this.veiculoPlaca = atendimento.getVeiculoPlaca();
                this.tipoOcorrencia = atendimento.getTipoOcorrencia();
                this.tipoServico = atendimento.getTipoServico();
                this.status = StatusDeAtendimento.CHAMADO;
                this.descricao = atendimento.getDescricao();
                this.dataHoraChamado = new Timestamp(System.currentTimeMillis());
                this.origem = atendimento.getOrigem() != null 
                        ? new JpaEndereco(atendimento.getOrigem().logradouro(), atendimento.getOrigem().numero(), atendimento.getOrigem().complemento(), 
                                atendimento.getOrigem().bairro(), atendimento.getOrigem().cidade(), atendimento.getOrigem().estado(), atendimento.getOrigem().cep()) : null;
                this.destino = atendimento.getDestino() != null
                        ? new JpaEndereco(atendimento.getDestino().logradouro(), atendimento.getDestino().numero(), atendimento.getDestino().complemento(), 
                                atendimento.getDestino().bairro(), atendimento.getDestino().cidade(), atendimento.getDestino().estado(), atendimento.getDestino().cep()) : null;
                this.base = atendimento.getBase() != null
                        ? new JpaEndereco(atendimento.getBase().logradouro(), atendimento.getBase().numero(), atendimento.getBase().complemento(), 
                                atendimento.getBase().bairro(), atendimento.getBase().cidade(), atendimento.getBase().estado(), atendimento.getBase().cep()) : null;
        }


        @Override
        public String toString() {
                return "{" +
                        " id='" + getId() + "'" +
                        ", prestadorId='" + getPrestadorId() + "'" +
                        ", clienteId='" + getClienteId() + "'" +
                        ", clienteNome='" + getClienteNome() + "'" +
                        ", clienteTelefone='" + getClienteTelefone() + "'" +
                        ", clienteWhatsapp='" + getClienteWhatsapp() + "'" +
                        ", veiculoId='" + getVeiculoId() + "'" +
                        ", veiculoPlaca='" + getVeiculoPlaca() + "'" +
                        ", tipoOcorrencia='" + getTipoOcorrencia() + "'" +
                        ", tipoServico='" + getTipoServico() + "'" +
                        ", status='" + getStatus() + "'" +
                        ", dataHoraChamado='" + getDataHoraChamado() + "'" +
                        ", dataHoraConfirmado='" + getDataHoraConfirmado() + "'" +
                        ", dataHoraEmAndamento='" + getDataHoraEmAndamento() + "'" +
                        ", dataHoraFinalizado='" + getDataHoraFinalizado() + "'" +
                        ", dataHoraCancelado='" + getDataHoraCancelado() + "'" +
                        ", descricao='" + getDescricao() + "'" +
                        ", base='" + getBase() + "'" +
                        ", origem='" + getOrigem() + "'" +
                        ", destino='" + getDestino() + "'" +
                        ", itemDeServicoDoAtendimentos='" + getItemDeServicoDoAtendimentos() + "'" +
                        "}";
        }

}