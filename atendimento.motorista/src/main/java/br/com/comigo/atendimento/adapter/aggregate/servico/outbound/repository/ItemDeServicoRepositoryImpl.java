package br.com.comigo.atendimento.adapter.aggregate.servico.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.adapter.aggregate.servico.outbound.JpaItemDeServico;
import br.com.comigo.atendimento.adapter.aggregate.servico.outbound.JpaServico;
import br.com.comigo.atendimento.domain.aggregate.servico.ItemDeServico;
import br.com.comigo.atendimento.domain.aggregate.servico.repository.ItemDeServicoRepository;
import br.com.comigo.atendimento.mapper.aggregate.servico.ItemDeServicoMapper;
import br.com.comigo.atendimento.mapper.aggregate.servico.ServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ItemDeServicoRepositoryImpl implements ItemDeServicoRepository {
    private final JpaServicoRepository jpaServicoRepository;
    private final JpaItemDeServicoRepository jpaItemDeServicoRepository;
    private final ServicoMapper servicoMapper;
    private final ItemDeServicoMapper itemDeServicoMapper;
    
    @Override
    public void create(ItemDeServico itemDeServico, Long servicoId) {
        JpaServico jpaServico = this.jpaServicoRepository.findById(servicoId)
                .orElseThrow(() -> new IllegalArgumentException("Prestador não encontrado"));
        itemDeServico.setServico(this.servicoMapper.fromJpaToDomain(jpaServico));

        JpaItemDeServico jpaItemDeServico = new JpaItemDeServico();
        jpaItemDeServico.setDescricao(itemDeServico.getDescricao());
        jpaItemDeServico.setNome(itemDeServico.getNome());
        jpaItemDeServico.setUnidadeMedida(itemDeServico.getUnidadeMedida());
        jpaItemDeServico.setServico(jpaServico);
        jpaServico.getItemDeServicos().add(jpaItemDeServico);

        this.jpaServicoRepository.save(jpaServico);
    }

    @Override
    public Optional<ItemDeServico> findById(Long id) {
        Optional<JpaItemDeServico> optional = this.jpaItemDeServicoRepository.findById(id);
        return optional.map(itemDeServicoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<ItemDeServico> findAll() {
        return this.jpaItemDeServicoRepository.findAll().stream()
            .map(itemDeServicoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaItemDeServicoRepository.deleteById(id);
    }
}