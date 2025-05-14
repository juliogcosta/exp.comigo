package br.com.comigo.usuario.api.adapter.aggregate.servico.dto;

public record ItemDeServicoDTO(
    Long id,
    String nome,
    String descricao,
    String unidadeMedida
) {
}