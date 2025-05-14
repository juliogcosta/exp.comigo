package br.com.comigo.usuario.api.application.aggregate.service.servico;

import org.springframework.stereotype.Service;

import br.com.comigo.usuario.api.adapter.aggregate.servico.dto.ItemDeServicoDTO;
import br.com.comigo.usuario.api.adapter.aggregate.servico.dto.ServicoDTO;
import br.com.comigo.usuario.api.application.usecase.servico.ServicoUseCases;
import br.com.comigo.usuario.api.domain.aggregate.servico.ItemDeServico;
import br.com.comigo.usuario.api.domain.aggregate.servico.Servico;
import br.com.comigo.usuario.api.domain.aggregate.servico.repository.ItemDeServicoRepository;
import br.com.comigo.usuario.api.domain.aggregate.servico.repository.ServicoRepository;
import br.com.comigo.usuario.api.mapper.aggregate.servico.ItemDeServicoMapper;
import br.com.comigo.usuario.api.mapper.aggregate.servico.ServicoMapper;
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
        Servico servico = this.servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servico not found"));
        return this.servicoMapper.toDto(servico);
    }

    @Override
    public ServicoDTO getServicoDetailsByNome(String nome) {
        Servico servico = this.servicoRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.servicoMapper.toDto(servico);
    }

    @Override
    public void deleteServico(Long id) {
        this.servicoRepository.deleteById(id);
    }

    @Override
    public void addItemDeServicoToServico(ItemDeServicoDTO itemDeServicoDTO, Long servicoId) {
        ItemDeServico itemDeServico = this.itemDeServicoMapper.toDomain(itemDeServicoDTO);
        this.itemDeServicoRepository.create(itemDeServico, servicoId);
    }

    @Override
    public void deleteItemDeServico(Long id) {
        this.itemDeServicoRepository.deleteById(id);
    }
}