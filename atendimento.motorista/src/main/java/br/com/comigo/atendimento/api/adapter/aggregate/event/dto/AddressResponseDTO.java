package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

public record AddressResponseDTO(
    Long id, 
    String city, 
    String state) {
}