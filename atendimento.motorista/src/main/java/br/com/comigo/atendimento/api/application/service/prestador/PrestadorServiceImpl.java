package br.com.comigo.atendimento.api.application.service.prestador;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.prestador.PrestadorDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.prestador.SetupDeItemDeServicoDTO;
import br.com.comigo.atendimento.api.application.usecase.PrestadorUseCases;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDeServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.repository.PrestadorRepository;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.repository.SetupDeItemDeServicoRepository;
import br.com.comigo.atendimento.api.domain.util.Cnpj;
import br.com.comigo.atendimento.api.domain.util.Telefone;
import br.com.comigo.atendimento.api.mapper.aggregate.prestador.PrestadorMapper;
import br.com.comigo.atendimento.api.mapper.aggregate.prestador.SetupDeItemDeServicoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrestadorServiceImpl implements PrestadorUseCases {

    private final PrestadorRepository prestadorRepository;
    private final SetupDeItemDeServicoRepository setupDeItemDeServicoRepository;
    private final PrestadorMapper prestadorMapper;
    private final SetupDeItemDeServicoMapper setupDeItemDeServicoMapper;

    @Override
    public PrestadorDTO create(PrestadorDTO dto) {
        Prestador prestador = this.prestadorRepository.create(this.prestadorMapper.toDomain(dto));
        return this.prestadorMapper.toDto(prestador);
    }

    @Override
    public void update(PrestadorDTO dto) {
        this.prestadorRepository.update(this.prestadorMapper.toDomain(dto));
    }

    @Override
    public PrestadorDTO getPrestadorDetailsById(Long id) {
        Prestador prestador = this.prestadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.prestadorMapper.toDto(prestador);
    }

    @Override
    public PrestadorDTO getPrestadorDetailsByCnpj(Cnpj cnpj) {
        Prestador prestador = this.prestadorRepository.findByCnpj(cnpj).orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.prestadorMapper.toDto(prestador);
    }

    @Override
    public List<PrestadorDTO> getFilteredPrestadorsByNome(String nome) {
        return this.prestadorRepository.findByNome(nome).stream()
            .map(prestadorMapper::toDto)
            .toList();
    }

    @Override
    public List<PrestadorDTO> getFilteredPrestadorsByTelefone(Telefone telefone) {
        return this.prestadorRepository.findByTelefone(telefone).stream()
            .map(prestadorMapper::toDto)
            .toList();
    }

    @Override
    public void deletePrestador(Long id) {
        this.prestadorRepository.deleteById(id);
    }

    @Override
    public void addSetupDeItemDoServicoToPrestador(SetupDeItemDeServicoDTO setupDeItemDeServicoDTO, Long prestadorId) {
        Prestador prestador = this.prestadorRepository.findById(prestadorId)
            .orElseThrow(() -> new RuntimeException("Crestador not found"));
        
        SetupDeItemDeServico setupDeItemDeServico = this.setupDeItemDeServicoMapper.toDomain(setupDeItemDeServicoDTO);
        setupDeItemDeServico.setPrestador(prestador);
        this.setupDeItemDeServicoRepository.create(setupDeItemDeServico);
    }

    @Override
    public void deleteSetupDeItemDoServico(Long id) {
        this.setupDeItemDeServicoRepository.deleteById(id);
    }
}