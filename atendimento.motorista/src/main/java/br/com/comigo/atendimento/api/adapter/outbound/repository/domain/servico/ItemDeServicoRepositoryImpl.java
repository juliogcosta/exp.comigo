package br.com.comigo.atendimento.api.adapter.outbound.repository.domain.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.servico.JpaItemDeServico;
import br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.servico.JpaItemDeServicoRepository;
import br.com.comigo.atendimento.api.domain.data.aggregate.servico.ItemDeServico;
import br.com.comigo.atendimento.api.domain.repository.ItemDeServicoRepository;
import br.com.comigo.atendimento.api.mapper.ItemDeServicoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ItemDeServicoRepositoryImpl implements ItemDeServicoRepository {
    private final JpaItemDeServicoRepository jpaItemDeServicoRepository;
    private final ItemDeServicoMapper itemDeServicoMapper;
    
    @Override
    public ItemDeServico create(ItemDeServico itemDeServico) {
        JpaItemDeServico jpaItemDeServico = new JpaItemDeServico(itemDeServico);
        jpaItemDeServico = this.jpaItemDeServicoRepository.save(jpaItemDeServico);
        itemDeServico.setId(jpaItemDeServico.getId());
        return itemDeServico;
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