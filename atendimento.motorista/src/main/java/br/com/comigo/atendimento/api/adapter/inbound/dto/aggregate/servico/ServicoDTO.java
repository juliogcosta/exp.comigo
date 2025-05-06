package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico;

import br.com.comigo.atendimento.api.domain.util.StatusDeServico;

public record ServicoDTO(
    String id,
    String nome,
    String descricao,
    StatusDeServico status
) {
}