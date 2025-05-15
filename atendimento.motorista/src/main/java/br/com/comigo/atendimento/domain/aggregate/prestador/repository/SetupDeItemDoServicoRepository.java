package br.com.comigo.atendimento.domain.aggregate.prestador.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.domain.aggregate.prestador.SetupDeItemDoServico;

public interface SetupDeItemDoServicoRepository {
    public void create(SetupDeItemDoServico setupDeItemDoServico, Long prestadorId);

    public Optional<SetupDeItemDoServico> findById(Long id);

    public List<SetupDeItemDoServico> findAll();

    public void deleteById(Long id);
}