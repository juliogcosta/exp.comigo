package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto;

public record ItemDeServicoDoAtendimentoDTO(
  Long id,
  Long setupDeItemDeServicoId,
  Integer quantidade,
  String observacao
) {
}