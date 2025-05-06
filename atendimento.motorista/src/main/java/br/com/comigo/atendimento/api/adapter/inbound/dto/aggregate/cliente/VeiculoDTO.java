package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.cliente;

public record VeiculoDTO(
    Long id,
    String marca,
    String modelo,
    String cor,
    String placa,
    String ano
) {
}