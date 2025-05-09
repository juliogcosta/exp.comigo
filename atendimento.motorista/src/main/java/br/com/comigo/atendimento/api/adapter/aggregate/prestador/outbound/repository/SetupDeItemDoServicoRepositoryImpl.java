package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaSetupDeItemDoServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDoServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.repository.SetupDeItemDoServicoRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.prestador.SetupDeItemDoServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SetupDeItemDoServicoRepositoryImpl implements SetupDeItemDoServicoRepository {
    private final JpaSetupDeItemDoServicoRepository jpaSetupDeItemDoServicoRepository;
    private final SetupDeItemDoServicoMapper setupDeItemDoServicoMapper;
    
    @Override
    public SetupDeItemDoServico create(SetupDeItemDoServico setupDeItemDoServico) {
        JpaSetupDeItemDoServico jpaSetupDeItemDoServico = new JpaSetupDeItemDoServico(setupDeItemDoServico);
        jpaSetupDeItemDoServico = this.jpaSetupDeItemDoServicoRepository.save(jpaSetupDeItemDoServico);
        setupDeItemDoServico.setId(jpaSetupDeItemDoServico.getId());
        return setupDeItemDoServico;
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