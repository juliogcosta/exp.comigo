package br.com.comigo.atendimento.api.adapter.outbound.util;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaEndereco {

    @Column(name = "endereco_rua", nullable = false)
    private String rua;

    @Column(name = "endereco_numero", nullable = false)
    private String numero;

    @Column(name = "endereco_complemento", nullable = true)
    private String complemento;

    @Column(name = "endereco_bairro", nullable = false)
    private String bairro;

    @Column(name = "endereco_cidade", nullable = false)
    private String cidade;

    @Column(name = "endereco_estado", nullable = false)
    private String estado;

    @Column(name = "endereco_cep", nullable = false, length = 8)
    private String cep;
}