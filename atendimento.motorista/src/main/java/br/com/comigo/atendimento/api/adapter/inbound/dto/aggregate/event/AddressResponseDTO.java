package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event;

public record AddressResponseDTO(
    Long id, 
    String city, 
    String state) {
}