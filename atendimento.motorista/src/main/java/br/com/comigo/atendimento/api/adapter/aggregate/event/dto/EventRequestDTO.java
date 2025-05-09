package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EventRequestDTO(
    Long id,
    @NotNull(message = "O título deve ser informado") String title,
    @NotNull(message = "A descrição deve ser informada") String description,
    @NotNull(message = "A data deve ser informada") Long date,
    @NotNull(message = "A cidade deve ser informada") String city,
    @NotNull(message = "O estado deve ser informado") String state,
    Boolean remote,
    @Pattern(regexp = "^(https?://)(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,63}){1,3}(/[a-zA-Z0-9._~:/?#\\[\\]@!$&'()*+,;=-]*)?$", 
        message = "URL inválida") @NotEmpty(message = "O link para o evento deve ser informado") String eventUrl) {
}
