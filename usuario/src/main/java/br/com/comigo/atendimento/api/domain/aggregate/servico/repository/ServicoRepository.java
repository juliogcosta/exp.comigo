package br.com.comigo.atendimento.api.domain.aggregate.servico.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.servico.Servico;

public interface ServicoRepository {
    public Servico create(Servico servico);

    public void update(Servico servico);

    public Optional<Servico> findById(Long id);

    public Optional<Servico> findByNome(String nome);

    public List<Servico> findAll();

    public void deleteById(Long id);
}