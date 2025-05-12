package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound;

import java.util.ArrayList;
import java.util.List;

import br.com.comigo.atendimento.api.adapter.util.JpaCnpj;
import br.com.comigo.atendimento.api.adapter.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.atendimento.api.domain.util.StatusDePrestador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestador", schema = "atendimento")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaPrestador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Embedded
        private JpaCnpj cnpj;

        @Embedded
        @AttributeOverrides({
                        @AttributeOverride(name = "numero", column = @Column(name = "telefone_numero")),
                        @AttributeOverride(name = "tipo", column = @Column(name = "telefone_tipo"))
        })
        private JpaTelefone telefone;

        @Embedded
        @AttributeOverrides({
                        @AttributeOverride(name = "numero", column = @Column(name = "whatsapp_numero")),
                        @AttributeOverride(name = "tipo", column = @Column(name = "whatsapp_tipo"))
        })
        private JpaTelefone whatsapp;

        @Embedded
        private JpaEmail email;

        @Embedded
        private JpaEndereco endereco;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private StatusDePrestador status;

        @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private List<JpaSetupDeItemDoServico> setupDeItemDoServicos = new ArrayList<>();

        public JpaPrestador(Prestador prestador) {
                this.nome = prestador.getNome();
                this.cnpj = new JpaCnpj(prestador.getCnpj().valor());
                this.telefone = new JpaTelefone(prestador.getTelefone().numero(), prestador.getTelefone().tipo());
                this.whatsapp = new JpaTelefone(prestador.getWhatsapp().numero(), prestador.getWhatsapp().tipo());
                this.email = new JpaEmail(prestador.getEmail().valor());
                this.endereco = new JpaEndereco(prestador.getEndereco().logradouro(),
                                prestador.getEndereco().numero(),
                                prestador.getEndereco().complemento(),
                                prestador.getEndereco().bairro(),
                                prestador.getEndereco().cidade(),
                                prestador.getEndereco().estado(),
                                prestador.getEndereco().cep());
                this.status = StatusDePrestador.ATIVO;
        }

        @Override
        public String toString() {
                return "{" +
                                " id='" + getId() + "'" +
                                ", nome='" + getNome() + "'" +
                                ", cnpj='" + getCnpj() + "'" +
                                ", telefone='" + getTelefone() + "'" +
                                ", whatsapp='" + getWhatsapp() + "'" +
                                ", email='" + getEmail() + "'" +
                                ", endereco='" + getEndereco() + "'" +
                                ", status='" + getStatus() + "'" +
                                ", setupDeItemDoServicos='" + getSetupDeItemDoServicos() + "'" +
                                "}";
        }

}