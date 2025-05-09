package br.com.comigo.atendimento.api.application.usecase;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.prestador.SetupDeItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico.ServicoDTO;

public interface ServicoUseCases {
    public ServicoDTO create(ServicoDTO dto);

    public void update(ServicoDTO dto);

    public ServicoDTO getServicoDetailsById(Long id);

    public ServicoDTO getServicoDetailsByNome(String nome);

    public void deleteServico(Long id);

    public void addSetupDeItemDoServicoToServico(SetupDeItemDeServicoDTO setupDeItemDeServicoDTO, Long servicoId);

    public void deleteSetupDeItemDeServico(Long id);
}