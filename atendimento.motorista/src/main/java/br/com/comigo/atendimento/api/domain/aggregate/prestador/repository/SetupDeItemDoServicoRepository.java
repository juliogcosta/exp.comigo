package br.com.comigo.atendimento.api.domain.aggregate.prestador.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDoServico;

public interface SetupDeItemDoServicoRepository {
    public SetupDeItemDoServico create(SetupDeItemDoServico setupDeItemDoServico);

    public Optional<SetupDeItemDoServico> findById(Long id);

    public List<SetupDeItemDoServico> findAll();

    public void deleteById(Long id);
}