package br.com.comigo.atendimento.application.aggregate.service.prestador;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.adapter.aggregate.prestador.dto.PrestadorDTO;
import br.com.comigo.atendimento.adapter.aggregate.prestador.dto.SetupDeItemDoServicoDTO;
import br.com.comigo.atendimento.application.usecase.prestador.PrestadorUseCases;
import br.com.comigo.atendimento.domain.aggregate.prestador.Prestador;
import br.com.comigo.atendimento.domain.aggregate.prestador.SetupDeItemDoServico;
import br.com.comigo.atendimento.domain.aggregate.prestador.repository.PrestadorRepository;
import br.com.comigo.atendimento.domain.aggregate.prestador.repository.SetupDeItemDoServicoRepository;
import br.com.comigo.atendimento.mapper.aggregate.prestador.PrestadorMapper;
import br.com.comigo.atendimento.mapper.aggregate.prestador.SetupDeItemDoServicoMapper;
import br.com.comigo.common.model.utils.Cnpj;
import br.com.comigo.common.model.utils.Telefone;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrestadorServiceImpl implements PrestadorUseCases {

    private final PrestadorRepository prestadorRepository;
    private final SetupDeItemDoServicoRepository setupDeItemDoServicoRepository;
    private final PrestadorMapper prestadorMapper;
    private final SetupDeItemDoServicoMapper setupDeItemDoServicoMapper;

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
        Prestador prestador = this.prestadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prestador not found"));
        return this.prestadorMapper.toDto(prestador);
    }

    @Override
    public PrestadorDTO getPrestadorDetailsByCnpj(Cnpj cnpj) {
        Prestador prestador = this.prestadorRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Prestador not found"));
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

    @Transactional
    @Override
    public void addSetupDeItemDoServicoToPrestador(SetupDeItemDoServicoDTO setupDeItemDoServicoDTO, Long prestadorId) {
        SetupDeItemDoServico setupDeItemDoServico = this.setupDeItemDoServicoMapper.toDomain(setupDeItemDoServicoDTO);
        this.setupDeItemDoServicoRepository.create(setupDeItemDoServico, prestadorId);
    }

    @Override
    public void deleteSetupDeItemDoServico(Long id) {
        this.setupDeItemDoServicoRepository.deleteById(id);
    }
}