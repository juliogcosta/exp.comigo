package br.com.comigo.atendimento.api.adapter.aggregate.servico.dto;

import java.util.List;

import br.com.comigo.atendimento.api.domain.util.StatusDeServico;

public record ServicoDTO(
    Long id,
    String nome,
    String descricao,
    StatusDeServico status,
    List<ItemDeServicoDTO> itemDeServicos
) {
}