package br.com.comigo.atendimento.domain.aggregate.servico.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.domain.aggregate.servico.ItemDeServico;

public interface ItemDeServicoRepository {
    public void create(ItemDeServico itemDeServico, Long servicoId);

    public Optional<ItemDeServico> findById(Long id);

    public List<ItemDeServico> findAll();

    public void deleteById(Long id);
}