package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.cliente;

import java.util.Date;
import java.util.List;

import br.com.comigo.atendimento.api.adapter.outbound.util.JpaCpf;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.Cliente;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
@Table(name = "cliente")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Embedded
    private JpaCpf cpf;

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

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<JpaVeiculo> veiculos;

    public JpaCliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = new JpaCpf(cliente.getCpf().value());
        this.telefone = new JpaTelefone(cliente.getTelefone().numero(), cliente.getTelefone().tipo());
        this.whatsapp = new JpaTelefone(cliente.getWhatsapp().numero(), cliente.getWhatsapp().tipo());
        this.email = new JpaEmail(cliente.getEmail().value());
        this.endereco = new JpaEndereco(cliente.getEndereco().rua(), 
                cliente.getEndereco().rua(),
                cliente.getEndereco().numero(),
                cliente.getEndereco().complemento(),
                cliente.getEndereco().bairro(),
                cliente.getEndereco().estado(),
                cliente.getEndereco().cep());
        this.dataNascimento = cliente.getDataNascimento();
    }
}