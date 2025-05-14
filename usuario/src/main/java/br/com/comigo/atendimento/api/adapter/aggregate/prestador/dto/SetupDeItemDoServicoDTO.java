package br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDoServico;

public record SetupDeItemDoServicoDTO(
        Long id,
        Integer precoUnitario,
        StatusDeSetupDeItemDoServico status,
        Long itemDeServicoId) {
}