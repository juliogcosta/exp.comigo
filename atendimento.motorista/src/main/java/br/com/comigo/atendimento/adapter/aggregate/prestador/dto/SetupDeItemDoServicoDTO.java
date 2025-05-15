package br.com.comigo.atendimento.adapter.aggregate.prestador.dto;

import br.com.comigo.atendimento.domain.util.StatusDeSetupDeItemDoServico;

public record SetupDeItemDoServicoDTO(
        Long id,
        Integer precoUnitario,
        StatusDeSetupDeItemDoServico status,
        Long itemDeServicoId) {
}