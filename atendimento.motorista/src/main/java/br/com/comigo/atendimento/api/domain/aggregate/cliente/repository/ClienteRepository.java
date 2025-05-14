package br.com.comigo.atendimento.api.domain.aggregate.cliente.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.cliente.Cliente;
import br.com.comigo.common.model.utils.Cpf;
import br.com.comigo.common.model.utils.Telefone;

public interface ClienteRepository {
    public Cliente create(Cliente event);

    public void update(Cliente event);

    public Optional<Cliente> findById(Long id);

    public Optional<Cliente> findByCpf(Cpf cpf);

    public List<Cliente> findByNome(String nome);

    public List<Cliente> findByTelefone(Telefone telefone);

    public void deleteById(Long id);
}