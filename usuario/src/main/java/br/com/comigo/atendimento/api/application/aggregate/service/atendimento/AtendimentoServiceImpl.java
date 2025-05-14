package br.com.comigo.atendimento.api.application.aggregate.service.atendimento;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.ItemDeServicoDoAtendimentoDTO;
import br.com.comigo.atendimento.api.application.usecase.atendimento.AtendimentoUseCases;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.Atendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.ItemDeServicoDoAtendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.repository.AtendimentoRepository;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.repository.ItemDeServicoDoAtendimentoRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.atendimento.AtendimentoMapper;
import br.com.comigo.atendimento.api.mapper.aggregate.atendimento.ItemDeServicoDoAtendimentoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtendimentoServiceImpl  implements AtendimentoUseCases {

    private final AtendimentoRepository atendimentoRepository;
    private final ItemDeServicoDoAtendimentoRepository itemDeServicoDoAtendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;
    private final ItemDeServicoDoAtendimentoMapper itemDeServicoDoAtendimentoMapper;

    @Override
    public AtendimentoDTO create(AtendimentoDTO dto) {
        Atendimento servico = this.atendimentoRepository.create(this.atendimentoMapper.toDomain(dto));
        return this.atendimentoMapper.toDto(servico);
    }

    @Override
    public void update(AtendimentoDTO dto) {
        this.atendimentoRepository.update(this.atendimentoMapper.toDomain(dto));
    }

    @Override
    public AtendimentoDTO getAtendimentoDetailsById(Long id) {
        Atendimento atendimento = this.atendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servico not found"));
        return this.atendimentoMapper.toDto(atendimento);
    }

    @Override
    public void deleteAtendimento(Long id) {
        this.atendimentoRepository.deleteById(id);
    }

    @Override
    public void addItemDeServicoDoAtendimentoToAtendimento(ItemDeServicoDoAtendimentoDTO itemDeServicoDoAtendimentoDTO, Long atendimentoId) {
        ItemDeServicoDoAtendimento itemDeServicoDoAtendimento = this.itemDeServicoDoAtendimentoMapper.toDomain(itemDeServicoDoAtendimentoDTO);
        this.itemDeServicoDoAtendimentoRepository.create(itemDeServicoDoAtendimento, atendimentoId);
    }

    @Override
    public void deleteItemDeServicoDoAtendimento(Long id) {
        this.itemDeServicoDoAtendimentoRepository.deleteById(id);
    }
}