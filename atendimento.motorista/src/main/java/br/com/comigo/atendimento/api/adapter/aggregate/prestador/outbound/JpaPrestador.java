package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound;

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
@Table(name = "prestador")
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
        @AttributeOverride(name = "numero", column = @Column(name = "telefone_numero")),
        @AttributeOverride(name = "tipo", column = @Column(name = "telefone_tipo"))
    })
    private JpaTelefone whatsapp;
    
    @Embedded
    private JpaEmail email;

    @Embedded
    private JpaEndereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDePrestador status;

    public JpaPrestador(Prestador prestador) {
        this.nome = prestador.getNome();
        this.cnpj = new JpaCnpj(prestador.getCnpj().value());
        this.telefone = new JpaTelefone(prestador.getTelefone().numero(), prestador.getTelefone().tipo());
        this.whatsapp = new JpaTelefone(prestador.getWhatsapp().numero(), prestador.getWhatsapp().tipo());
        this.email = new JpaEmail(prestador.getEmail().value());
        this.endereco = new JpaEndereco(prestador.getEndereco().rua(), 
                prestador.getEndereco().rua(),
                prestador.getEndereco().numero(),
                prestador.getEndereco().complemento(),
                prestador.getEndereco().bairro(),
                prestador.getEndereco().estado(),
                prestador.getEndereco().cep());
        this.status = StatusDePrestador.ATIVO;
    }
}