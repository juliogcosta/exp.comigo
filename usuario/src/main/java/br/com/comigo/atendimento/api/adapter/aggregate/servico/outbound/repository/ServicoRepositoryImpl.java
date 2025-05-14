package br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.JpaServico;
import br.com.comigo.atendimento.api.domain.aggregate.servico.Servico;
import br.com.comigo.atendimento.api.domain.aggregate.servico.repository.ServicoRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.servico.ServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ServicoRepositoryImpl implements ServicoRepository {

    private final JpaServicoRepository jpaServicoRepository;
    private final ServicoMapper servicoMapper;

    @Override
    public Servico create(Servico servico) {
        JpaServico jpaServico = new JpaServico(servico);
        jpaServico = this.jpaServicoRepository.save(jpaServico);
        servico.setId(jpaServico.getId());
        return servico;
    }

    @Override
    public void update(Servico servico) {
        JpaServico jpaServico = this.jpaServicoRepository.findById(servico.getId())
            .orElseThrow(() -> new IllegalArgumentException("Servico não encontrado"));
        jpaServico.setNome(servico.getNome());
        jpaServico.setDescricao(servico.getDescricao());
        jpaServico.setStatus(servico.getStatus());
        this.jpaServicoRepository.save(jpaServico);
    }

    @Override
    public Optional<Servico> findById(Long id) {
        Optional<JpaServico> optional = this.jpaServicoRepository.findById(id);
        return optional.map(servicoMapper::fromJpaToDomain);
    }

    @Override
    public Optional<Servico> findByNome(String nome) {
        Optional<JpaServico> optional = this.jpaServicoRepository.findByNome(nome);
        return optional.map(servicoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<Servico> findAll() {
        return this.jpaServicoRepository.findAll().stream()
            .map(servicoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaServicoRepository.deleteById(id);
    }
}