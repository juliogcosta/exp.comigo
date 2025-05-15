package br.com.comigo.usuario.api.adapter.aggregate.usuario.dto;

import java.util.Date;
import java.util.List;

import br.com.comigo.common.model.utils.Cpf;
import br.com.comigo.common.model.utils.Email;
import br.com.comigo.common.model.utils.Endereco;
import br.com.comigo.common.model.utils.Telefone;

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