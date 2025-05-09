package br.com.comigo.atendimento.api.adapter.aggregate.servico.dto;

import br.com.comigo.atendimento.api.domain.util.StatusDeServico;

public record ServicoDTO(
    String id,
    String nome,
    String descricao,
    StatusDeServico status
) {
}