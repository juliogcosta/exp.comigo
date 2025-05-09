package br.com.comigo.atendimento.api.application.usecase;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico.ItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico.ServicoDTO;

public interface ServicoUseCases {
    public ServicoDTO create(ServicoDTO dto);

    public void update(ServicoDTO dto);

    public ServicoDTO getServicoDetailsById(Long id);

    public ServicoDTO getServicoDetailsByNome(String nome);

    public void deleteServico(Long id);

    public void addItemDeServicoToServico(ItemDeServicoDTO itemDeServicoDTO, Long servicoId);

    public void deleteItemDeServico(Long id);
}