package br.com.comigo.usuario.adapter.util;

import br.com.comigo.common.model.utils.TipoDeTelefone;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class JpaTelefone {

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TipoDeTelefone tipo;

    @Column(nullable = true, length = 15)
    private String numero;

    public JpaTelefone(String numero, TipoDeTelefone tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
}