package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository.JpaSetupDeItemDeServicoRepository;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDeServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.repository.SetupDeItemDeServicoRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.prestador.SetupDeItemDeServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SetupDeItemDeServicoRepositoryImpl implements SetupDeItemDeServicoRepository {
    private final JpaSetupDeItemDeServicoRepository jpaSetupDeItemDeServicoRepository;
    private final SetupDeItemDeServicoMapper setupDeItemDeServicoMapper;
    
    @Override
    public SetupDeItemDeServico create(SetupDeItemDeServico setupDeItemDeServico) {
        JpaSetupDeItemDeServico jpaSetupDeItemDeServico = new JpaSetupDeItemDeServico(setupDeItemDeServico);
        jpaSetupDeItemDeServico = this.jpaSetupDeItemDeServicoRepository.save(jpaSetupDeItemDeServico);
        setupDeItemDeServico.setId(jpaSetupDeItemDeServico.getId());
        return setupDeItemDeServico;
    }

    @Override
    public Optional<SetupDeItemDeServico> findById(Long id) {
        Optional<JpaSetupDeItemDeServico> optional = this.jpaSetupDeItemDeServicoRepository.findById(id);
        return optional.map(setupDeItemDeServicoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<SetupDeItemDeServico> findAll() {
        return this.jpaSetupDeItemDeServicoRepository.findAll().stream()
            .map(setupDeItemDeServicoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaSetupDeItemDeServicoRepository.deleteById(id);
    }
}