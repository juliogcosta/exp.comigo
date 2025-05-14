package br.com.comigo.usuario.api.application.usecase.atendimento;

import br.com.comigo.usuario.api.adapter.aggregate.atendimento.dto.AtendimentoDTO;
import br.com.comigo.usuario.api.adapter.aggregate.atendimento.dto.ItemDeServicoDoAtendimentoDTO;

public interface AtendimentoUseCases {
    public AtendimentoDTO create(AtendimentoDTO dto);

    public void update(AtendimentoDTO dto);

    public AtendimentoDTO getAtendimentoDetailsById(Long id);

    public void deleteAtendimento(Long id);

    public void addItemDeServicoDoAtendimentoToAtendimento(ItemDeServicoDoAtendimentoDTO itemDeServicoDoAtendimentoDTO, Long atendimentoId);

    public void deleteItemDeServicoDoAtendimento(Long id);
}