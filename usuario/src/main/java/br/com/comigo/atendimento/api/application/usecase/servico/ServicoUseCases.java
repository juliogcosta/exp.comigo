package br.com.comigo.atendimento.api.application.usecase.servico;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.dto.ItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.servico.dto.ServicoDTO;

public interface ServicoUseCases {
    public ServicoDTO create(ServicoDTO dto);

    public void update(ServicoDTO dto);

    public ServicoDTO getServicoDetailsById(Long id);

    public ServicoDTO getServicoDetailsByNome(String nome);

    public void deleteServico(Long id);

    public void addItemDeServicoToServico(ItemDeServicoDTO itemDeServicoDTO, Long servicoId);

    public void deleteItemDeServico(Long id);
}