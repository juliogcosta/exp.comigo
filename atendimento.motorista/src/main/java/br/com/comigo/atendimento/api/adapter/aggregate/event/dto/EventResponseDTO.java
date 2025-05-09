package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

public record EventResponseDTO(
    Long id, 
    String title, 
    String description, 
    Long date, 
    String city, 
    String state, 
    Boolean remote, 
    String eventUrl) {
}
