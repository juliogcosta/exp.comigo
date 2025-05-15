package br.com.comigo.atendimento.adapter.aggregate.prestador.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.adapter.aggregate.prestador.outbound.JpaPrestador;
import br.com.comigo.atendimento.adapter.aggregate.prestador.outbound.JpaSetupDeItemDoServico;
import br.com.comigo.atendimento.domain.aggregate.prestador.SetupDeItemDoServico;
import br.com.comigo.atendimento.domain.aggregate.prestador.repository.SetupDeItemDoServicoRepository;
import br.com.comigo.atendimento.mapper.aggregate.prestador.PrestadorMapper;
import br.com.comigo.atendimento.mapper.aggregate.prestador.SetupDeItemDoServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SetupDeItemDoServicoRepositoryImpl implements SetupDeItemDoServicoRepository {
    private final JpaPrestadorRepository jpaPrestadorRepository;
    private final PrestadorMapper prestadorMapper;
    private final JpaSetupDeItemDoServicoRepository jpaSetupDeItemDoServicoRepository;
    private final SetupDeItemDoServicoMapper setupDeItemDoServicoMapper;

    @Override
    public void create(SetupDeItemDoServico setupDeItemDoServico, Long prestadorId) {
        JpaPrestador jpaPrestador = this.jpaPrestadorRepository.findById(prestadorId)
                .orElseThrow(() -> new IllegalArgumentException("Prestador não encontrado"));
        setupDeItemDoServico.setPrestador(this.prestadorMapper.fromJpaToDomain(jpaPrestador));

        JpaSetupDeItemDoServico jpaSetupDeItemDoServico = new JpaSetupDeItemDoServico();
        jpaSetupDeItemDoServico.setPrecoUnitario(setupDeItemDoServico.getPrecoUnitario());
        jpaSetupDeItemDoServico.setStatus(setupDeItemDoServico.getStatus());
        jpaSetupDeItemDoServico.setItemDeServicoId(setupDeItemDoServico.getItemDeServicoId());
        jpaSetupDeItemDoServico.setPrestador(jpaPrestador);

        jpaPrestador.getSetupDeItemDoServicos().add(jpaSetupDeItemDoServico);

        this.jpaPrestadorRepository.save(jpaPrestador);
    }

    @Override
    public Optional<SetupDeItemDoServico> findById(Long id) {
        Optional<JpaSetupDeItemDoServico> optional = this.jpaSetupDeItemDoServicoRepository.findById(id);
        return optional.map(setupDeItemDoServicoMapper::fromJpaToDomain);
    }

    @Override
    public List<SetupDeItemDoServico> findAll() {
        return this.jpaSetupDeItemDoServicoRepository.findAll().stream()
                .map(setupDeItemDoServicoMapper::fromJpaToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaSetupDeItemDoServicoRepository.deleteById(id);
    }
}