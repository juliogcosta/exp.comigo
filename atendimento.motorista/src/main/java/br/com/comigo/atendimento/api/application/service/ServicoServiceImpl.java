package br.com.comigo.atendimento.api.application.service;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico.ItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.servico.ServicoDTO;
import br.com.comigo.atendimento.api.application.usecase.ServicoUseCases;
import br.com.comigo.atendimento.api.domain.data.aggregate.servico.ItemDeServico;
import br.com.comigo.atendimento.api.domain.data.aggregate.servico.Servico;
import br.com.comigo.atendimento.api.domain.repository.ItemDeServicoRepository;
import br.com.comigo.atendimento.api.domain.repository.ServicoRepository;
import br.com.comigo.atendimento.api.mapper.ItemDeServicoMapper;
import br.com.comigo.atendimento.api.mapper.ServicoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoUseCases {

    private final ServicoRepository servicoRepository;
    private final ItemDeServicoRepository itemDeServicoRepository;
    private final ServicoMapper servicoMapper;
    private final ItemDeServicoMapper itemDeServicoMapper;

    @Override
    public ServicoDTO create(ServicoDTO dto) {
        Servico servico = this.servicoRepository.create(this.servicoMapper.toDomain(dto));
        return this.servicoMapper.toDto(servico);
    }

    @Override
    public void update(ServicoDTO dto) {
        this.servicoRepository.update(this.servicoMapper.toDomain(dto));
    }

    @Override
    public ServicoDTO getServicoDetailsById(Long id) {
        Servico servico = this.servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.servicoMapper.toDto(servico);
    }

    @Override
    public ServicoDTO getServicoDetailsByNome(String nome) {
        Servico servico = this.servicoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.servicoMapper.toDto(servico);
    }

    @Override
    public void deleteServico(Long id) {
        this.servicoRepository.deleteById(id);
    }

    @Override
    public void addItemDeServicoToServico(ItemDeServicoDTO itemDeServicoDTO, Long servicoId) {
        Servico prestador = this.servicoRepository.findById(servicoId)
            .orElseThrow(() -> new RuntimeException("Servico not found"));
        
        ItemDeServico itemDeServico = this.itemDeServicoMapper.toDomain(itemDeServicoDTO);
        itemDeServico.setServico(prestador);
        this.itemDeServicoRepository.create(itemDeServico);
    }

    @Override
    public void deleteItemDeServico(Long id) {
        this.itemDeServicoRepository.deleteById(id);
    }
}