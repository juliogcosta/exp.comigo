package br.com.comigo.atendimento.api.domain.aggregate.servico.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.servico.ItemDeServico;

public interface ItemDeServicoRepository {
    public ItemDeServico create(ItemDeServico itemDeServico);

    public Optional<ItemDeServico> findById(Long id);

    public List<ItemDeServico> findAll();

    public void deleteById(Long id);
}