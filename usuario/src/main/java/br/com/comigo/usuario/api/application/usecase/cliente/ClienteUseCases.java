package br.com.comigo.usuario.api.application.usecase.cliente;

import java.util.List;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.ClienteDTO;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.VeiculoDTO;
import br.com.comigo.usuario.api.domain.util.Cpf;
import br.com.comigo.usuario.api.domain.util.Telefone;

public interface ClienteUseCases {
    public ClienteDTO create(ClienteDTO dto);

    public void update(ClienteDTO dto);

    public ClienteDTO getClienteDetailsById(Long id);

    public ClienteDTO getClienteDetailsByCpf(Cpf cpf);

    public List<ClienteDTO> getFilteredClientesByNome(String nome);

    public List<ClienteDTO> getFilteredClientesByTelefone(Telefone telefone);

    public void deleteCliente(Long id);

    public void addVeiculoToCliente(VeiculoDTO veiculoDTO, Long clienteId);

    public void deleteVeiculo(Long id);
}
