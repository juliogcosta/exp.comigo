package br.com.comigo.atendimento.api.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.data.aggregate.cliente.Veiculo;

public interface VeiculoRepository {
    public Veiculo create(Veiculo veiculo);

    public Optional<Veiculo> findById(Long id);

    public List<Veiculo> findAll();

    public void deleteById(Long id);
}