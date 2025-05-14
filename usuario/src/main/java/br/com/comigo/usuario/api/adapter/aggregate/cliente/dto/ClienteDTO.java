package br.com.comigo.usuario.api.adapter.aggregate.cliente.dto;

import java.util.Date;
import java.util.List;

import br.com.comigo.usuario.api.domain.util.Cpf;
import br.com.comigo.usuario.api.domain.util.Email;
import br.com.comigo.usuario.api.domain.util.Endereco;
import br.com.comigo.usuario.api.domain.util.Telefone;

public record ClienteDTO(
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
}