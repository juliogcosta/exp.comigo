package br.com.comigo.atendimento.api.adapter.aggregate.cliente.dto;

import java.util.Date;
import java.util.List;

import br.com.comigo.common.model.utils.Cpf;
import br.com.comigo.common.model.utils.Email;
import br.com.comigo.common.model.utils.Endereco;
import br.com.comigo.common.model.utils.Telefone;

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