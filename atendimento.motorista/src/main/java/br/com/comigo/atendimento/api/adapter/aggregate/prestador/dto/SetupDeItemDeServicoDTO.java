package br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDoServico;

public record SetupDeItemDeServicoDTO(
    Long id,
    Integer precoUnitario,
    StatusDeSetupDeItemDoServico status,
    Long itemDeServicoId
) {
}