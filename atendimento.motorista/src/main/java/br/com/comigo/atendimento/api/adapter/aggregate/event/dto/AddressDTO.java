package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

public record AddressDTO (
    Long id,
    String city,
    String state) {
}