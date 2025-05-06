package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico;

public record ItemDeServicoDTO(
    Long id,
    String nome,
    String descricao,
    String unidadeMedida
) {
}