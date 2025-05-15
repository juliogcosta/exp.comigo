package br.com.comigo.atendimento.adapter.aggregate.servico.dto;

import java.util.List;

import br.com.comigo.atendimento.domain.util.StatusDeServico;

public record ServicoDTO(
    Long id,
    String nome,
    String descricao,
    StatusDeServico status,
    List<ItemDeServicoDTO> itemDeServicos
) {
}