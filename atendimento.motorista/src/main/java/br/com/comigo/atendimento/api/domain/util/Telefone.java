package br.com.comigo.atendimento.api.domain.util;

import java.util.regex.Pattern;

public record Telefone(String value) {

    private static final Pattern TELEFONE_PATTERN = Pattern.compile(
        "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{2}\\)?[-.\\s]?\\d{4,5}[-.\\s]?\\d{4}$"
    );

    public Telefone {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
        }
        if (!TELEFONE_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Telefone inválido");
        }
    }
}