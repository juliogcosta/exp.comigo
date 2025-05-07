package br.com.comigo.atendimento.api.adapter.outbound.aggregate.prestador;

import br.com.comigo.atendimento.api.adapter.outbound.util.JpaCnpj;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaTelefone;
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
}