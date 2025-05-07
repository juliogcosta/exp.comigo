package br.com.comigo.atendimento.api.adapter.outbound.aggregate.cliente;

import java.util.Date;

import br.com.comigo.atendimento.api.adapter.outbound.util.JpaCpf;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.outbound.util.JpaTelefone;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
}