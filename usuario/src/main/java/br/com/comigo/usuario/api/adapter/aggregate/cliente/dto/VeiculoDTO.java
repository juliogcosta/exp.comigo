package br.com.comigo.usuario.api.adapter.aggregate.cliente.dto;

public record VeiculoDTO(
    Long id,
    String marca,
    String modelo,
    String cor,
    String placa,
    String ano
) {
}