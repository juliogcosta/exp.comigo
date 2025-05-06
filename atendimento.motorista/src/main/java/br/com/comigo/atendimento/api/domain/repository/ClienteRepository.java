package br.com.comigo.atendimento.api.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.data.aggregate.cliente.Cliente;

public interface ClienteRepository {
    Cliente save(Cliente event);

    Optional<Cliente> findById(Long id);

    List<Cliente> findAll();

    void deleteById(Long id);
}