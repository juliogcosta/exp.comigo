package br.com.comigo.usuario.adapter.aggregate.papel.dto;

import br.com.comigo.usuario.domain.util.StatusDePapel;

public record PapelDTO(
        Long id,
        String nome,
        StatusDePapel status) {
}