package br.com.comigo.atendimento.api.application.aggregate.service.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.aggregate.cliente.dto.ClienteDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.cliente.dto.VeiculoDTO;
import br.com.comigo.atendimento.api.application.usecase.cliente.ClienteUseCases;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.Cliente;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.Veiculo;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.repository.ClienteRepository;
import br.com.comigo.atendimento.api.domain.aggregate.cliente.repository.VeiculoRepository;
import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Telefone;
import br.com.comigo.atendimento.api.mapper.aggregate.cliente.ClienteMapper;
import br.com.comigo.atendimento.api.mapper.aggregate.cliente.VeiculoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteUseCases {

    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final ClienteMapper clienteMapper;
    private final VeiculoMapper veiculoMapper;

    @Override
    public ClienteDTO create(ClienteDTO dto) {
        Cliente cliente = this.clienteRepository.create(this.clienteMapper.toDomain(dto));
        return this.clienteMapper.toDto(cliente);
    }

    @Override
    public void update(ClienteDTO dto) {
        this.clienteRepository.update(this.clienteMapper.toDomain(dto));
    }

    @Override
    public ClienteDTO getClienteDetailsById(Long id) {
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        return this.clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDTO getClienteDetailsByCpf(Cpf cpf) {
        Cliente cliente = this.clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        return this.clienteMapper.toDto(cliente);
    }

    @Override
    public List<ClienteDTO> getFilteredClientesByNome(String nome) {
        return this.clienteRepository.findByNome(nome).stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    @Override
    public List<ClienteDTO> getFilteredClientesByTelefone(Telefone telefone) {
        return this.clienteRepository.findByTelefone(telefone).stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    @Override
    public void deleteCliente(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addVeiculoToCliente(VeiculoDTO veiculoDTO, Long clienteId) {
        Veiculo veiculo = this.veiculoMapper.toDomain(veiculoDTO);

        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        if (cliente.getVeiculos() == null) {
            cliente.setVeiculos(new ArrayList<>());
        }

        veiculo.setCliente(cliente);
        cliente.getVeiculos().add(veiculo);

        this.clienteRepository.update(cliente);
    }

    @Override
    public void deleteVeiculo(Long id) {
        this.veiculoRepository.deleteById(id);
    }
}