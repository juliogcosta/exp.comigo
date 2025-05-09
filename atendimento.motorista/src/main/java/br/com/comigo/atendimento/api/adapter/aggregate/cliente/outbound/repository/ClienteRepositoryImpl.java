package br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound.JpaCliente;
import br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound.JpaClienteRepository;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.Cliente;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.repository.ClienteRepository;
import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Telefone;
import br.com.comigo.atendimento.api.mapper.aggregate.cliente.ClienteMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private final JpaClienteRepository jpaClienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public Cliente create(Cliente cliente) {
        JpaCliente jpaCliente = new JpaCliente(cliente);
        jpaCliente = this.jpaClienteRepository.save(jpaCliente);
        cliente.setId(jpaCliente.getId());
        return cliente;
    }

    @Override
    public void update(Cliente cliente) {
        JpaCliente jpaCliente = new JpaCliente(cliente);
        this.jpaClienteRepository.update(jpaCliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<JpaCliente> optional = this.jpaClienteRepository.findById(id);
        return optional.map(clienteMapper::fromJpaToDomain);
    }

    @Override
    public Optional<Cliente> findByCpf(Cpf cpf) {
        Optional<JpaCliente> optional = this.jpaClienteRepository.findByCpf_Cpf(cpf.value());
        return optional.map(clienteMapper::fromJpaToDomain);
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return this.jpaClienteRepository.findByNome(nome).stream()
            .map(clienteMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findByTelefone(Telefone telefone) {
        return this.jpaClienteRepository.findByTelefone_Numero(telefone.numero()).stream()
            .map(clienteMapper::fromJpaToDomain)
            .collect(Collectors.toList());
    }
    
    @Override
    public void deleteById(Long id) {
        this.jpaClienteRepository.deleteById(id);
    }
}