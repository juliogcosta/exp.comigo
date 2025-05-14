package br.com.comigo.atendimento.api.domain.aggregate.cliente.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.cliente.Veiculo;

public interface VeiculoRepository {
    public void create(Veiculo veiculo, Long clienteId);

    public Optional<Veiculo> findById(Long id);

    public List<Veiculo> findAll();

    public void deleteById(Long id);
}