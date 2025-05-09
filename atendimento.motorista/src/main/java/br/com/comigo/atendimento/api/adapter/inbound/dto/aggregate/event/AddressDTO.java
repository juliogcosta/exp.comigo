package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event;

public record AddressDTO (
    Long id,
    String city,
    String state) {
}