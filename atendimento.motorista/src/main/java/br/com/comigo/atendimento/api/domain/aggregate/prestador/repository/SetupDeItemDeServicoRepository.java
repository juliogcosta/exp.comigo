package br.com.comigo.atendimento.api.domain.aggregate.prestador.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDeServico;

public interface SetupDeItemDeServicoRepository {
    public SetupDeItemDeServico create(SetupDeItemDeServico setupDeItemDeServico);

    public Optional<SetupDeItemDeServico> findById(Long id);

    public List<SetupDeItemDeServico> findAll();

    public void deleteById(Long id);
}