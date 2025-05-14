package br.com.comigo.usuario.api.adapter.aggregate.prestador.dto;

import br.com.comigo.usuario.api.domain.util.StatusDeSetupDeItemDoServico;

public record SetupDeItemDoServicoDTO(
        Long id,
        Integer precoUnitario,
        StatusDeSetupDeItemDoServico status,
        Long itemDeServicoId) {
}