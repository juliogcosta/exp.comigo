package br.com.comigo.usuario.api.domain.aggregate.atendimento.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.usuario.api.domain.aggregate.atendimento.ItemDeServicoDoAtendimento;

public interface ItemDeServicoDoAtendimentoRepository {
    public void create(ItemDeServicoDoAtendimento itemDeServicoDoAtendimento, Long atendimentoId);

    public Optional<ItemDeServicoDoAtendimento> findById(Long id);

    public List<ItemDeServicoDoAtendimento> findAll();

    public void deleteById(Long id);
}