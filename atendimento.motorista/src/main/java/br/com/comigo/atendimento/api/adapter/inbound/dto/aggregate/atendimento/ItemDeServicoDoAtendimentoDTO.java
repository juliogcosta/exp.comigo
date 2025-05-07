package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.atendimento;

public record ItemDeServicoDoAtendimentoDTO(
  Long id,
  Long setupDeItemDeServicoId,
  Integer quantidade,
  String observacao
) {
}