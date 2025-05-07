package br.com.comigo.atendimento.api.adapter.outbound.util;

import br.com.comigo.atendimento.api.domain.util.TipoDeTelefone;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JpaTelefone {

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 15)
    private TipoDeTelefone tipo;

    @Column(nullable = true, length = 15)
    private String numero;
}