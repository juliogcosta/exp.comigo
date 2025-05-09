package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.cliente;

import java.util.Date;
import java.util.List;

import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

public record ClienteVeiculoProjectionDTO(
    Long id,
    String nome,
    Cpf cpf,
    Telefone telefone,
    Telefone whatsapp,
    Email email,
    Endereco endereco,
    Date dataNascimento,
    List<VeiculoDTO> veiculos
) {
    public record VeiculoDTO(
        String marca,
        String modelo,
        String cor,
        String placa,
        String ano
    ) {
    }
}