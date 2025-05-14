package br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound.JpaCliente;
import br.com.comigo.atendimento.api.adapter.util.JpaCpf;
import br.com.comigo.atendimento.api.adapter.util.JpaEmail;
import br.com.comigo.atendimento.api.adapter.util.JpaEndereco;
import br.com.comigo.atendimento.api.adapter.util.JpaTelefone;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.Cliente;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.repository.ClienteRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.cliente.ClienteMapper;
import br.com.comigo.common.model.utils.Cpf;
import br.com.comigo.common.model.utils.Telefone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        JpaCliente jpaCliente = this.jpaClienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        jpaCliente.setCpf(new JpaCpf(cliente.getCpf().valor()));
        jpaCliente.setNome(cliente.getNome());
        jpaCliente.setEmail(new JpaEmail(cliente.getEmail().valor()));
        jpaCliente.setTelefone(new JpaTelefone(cliente.getTelefone().numero(), cliente.getTelefone().tipo()));
        jpaCliente.setWhatsapp(new JpaTelefone(cliente.getWhatsapp().numero(), cliente.getWhatsapp().tipo()));
        jpaCliente.setEndereco(new JpaEndereco(cliente.getEndereco().logradouro(), cliente.getEndereco().numero(),
                cliente.getEndereco().complemento(), cliente.getEndereco().bairro(),
                cliente.getEndereco().cidade(), cliente.getEndereco().estado(), cliente.getEndereco().cep()));
        jpaCliente.setDataNascimento(cliente.getDataNascimento());
        this.jpaClienteRepository.save(jpaCliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<JpaCliente> optional = this.jpaClienteRepository.findById(id);
        return optional.map(clienteMapper::fromJpaToDomain);
    }

    @Override
    public Optional<Cliente> findByCpf(Cpf cpf) {
        Optional<JpaCliente> optional = this.jpaClienteRepository.findByCpf_Cpf(cpf.valor());
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