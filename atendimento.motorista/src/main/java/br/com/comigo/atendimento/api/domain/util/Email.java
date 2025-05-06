package br.com.comigo.atendimento.api.domain.util;

import java.util.regex.Pattern;

public record Email(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    public Email {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Email inválido");
        }
    }
}