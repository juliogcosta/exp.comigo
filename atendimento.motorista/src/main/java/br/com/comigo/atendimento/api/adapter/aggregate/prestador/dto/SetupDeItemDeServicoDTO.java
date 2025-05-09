package br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDeServico;

public record SetupDeItemDeServicoDTO(
    Long id,
    Integer precoUnitario,
    StatusDeSetupDeItemDeServico status,
    Long itemDeServicoId
) {
}