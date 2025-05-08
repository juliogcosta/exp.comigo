package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.cliente;

import java.util.Date;

import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

public record ClienteDTO(
    Long id,
    String nome,
    Cpf cpf,
    Telefone telefone,
    Telefone whatsapp,
    Email email,
    Endereco endereco,
    Date dataNascimento
) {
}