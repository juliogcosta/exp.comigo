package br.com.comigo.atendimento.api.adapter.aggregate.servico.dto;

public record ItemDeServicoDTO(
    Long id,
    String nome,
    String descricao,
    String unidadeMedida
) {
}