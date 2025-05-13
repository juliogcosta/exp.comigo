package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.JpaAtendimento;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.JpaItemDeServicoDoAtendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.ItemDeServicoDoAtendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.repository.ItemDeServicoDoAtendimentoRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.atendimento.AtendimentoMapper;
import br.com.comigo.atendimento.api.mapper.aggregate.atendimento.ItemDeServicoDoAtendimentoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ItemDeServicoDoAtendimentoRepositoryImpl implements ItemDeServicoDoAtendimentoRepository {
    private final JpaAtendimentoRepository jpaAtendimentoRepository;
    private final JpaItemDeServicoDoAtendimentoRepository jpaItemDeServicoDoAtendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;
    private final ItemDeServicoDoAtendimentoMapper itemDeServicoDoAtendimentoMapper;
    
    @Override
    public void create(ItemDeServicoDoAtendimento itemDeServicoDoAtendimento, Long atendimentoId) {
        JpaAtendimento jpaAtendimento = this.jpaAtendimentoRepository.findById(atendimentoId)
                .orElseThrow(() -> new IllegalArgumentException("Prestador não encontrado"));
        itemDeServicoDoAtendimento.setAtendimento(this.atendimentoMapper.fromJpaToDomain(jpaAtendimento));

        JpaItemDeServicoDoAtendimento jpaItemDeServicoDoAtendimento = new JpaItemDeServicoDoAtendimento();
        jpaItemDeServicoDoAtendimento.setSetupDeItemDoServicoId(itemDeServicoDoAtendimento.getId());
        jpaItemDeServicoDoAtendimento.setQuantidade(itemDeServicoDoAtendimento.getQuantidade());
        jpaItemDeServicoDoAtendimento.setObservacao(itemDeServicoDoAtendimento.getObservacao());
        jpaItemDeServicoDoAtendimento.setAtendimento(jpaAtendimento);
        jpaAtendimento.getItemDeServicoDoAtendimentos().add(jpaItemDeServicoDoAtendimento);

        this.jpaAtendimentoRepository.save(jpaAtendimento);
    }

    @Override
    public Optional<ItemDeServicoDoAtendimento> findById(Long id) {
        Optional<JpaItemDeServicoDoAtendimento> optional = this.jpaItemDeServicoDoAtendimentoRepository.findById(id);
        return optional.map(itemDeServicoDoAtendimentoMapper::fromJpaToDomain);
    }
    
    @Override
    public List<ItemDeServicoDoAtendimento> findAll() {
        return this.jpaItemDeServicoDoAtendimentoRepository.findAll().stream()
            .map(itemDeServicoDoAtendimentoMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaItemDeServicoDoAtendimentoRepository.deleteById(id);
    }
}