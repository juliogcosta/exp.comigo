package br.com.comigo.atendimento.api.adapter.util;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
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

    public JpaEndereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}