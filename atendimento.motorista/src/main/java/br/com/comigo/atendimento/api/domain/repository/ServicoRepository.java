package br.com.comigo.atendimento.api.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.data.aggregate.servico.Servico;

public interface ServicoRepository {
    Servico save(Servico servico);

    Optional<Servico> findById(Long id);

    List<Servico> findAll();

    void deleteById(Long id);
}