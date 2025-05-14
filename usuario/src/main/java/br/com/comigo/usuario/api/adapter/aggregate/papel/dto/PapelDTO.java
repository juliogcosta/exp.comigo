package br.com.comigo.usuario.api.adapter.aggregate.papel.dto;

import br.com.comigo.usuario.api.domain.util.StatusDePapel;

public record PapelDTO(
        Long id,
        String nome,
        StatusDePapel status) {
}