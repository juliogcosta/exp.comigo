package br.com.comigo.atendimento.api.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.data.aggregate.servico.ItemDeServico;

public interface ItemDeServicoRepository {
    ItemDeServico save(ItemDeServico itemDeServico);

    Optional<ItemDeServico> findById(Long id);

    List<ItemDeServico> findAll();

    void deleteById(Long id);
}