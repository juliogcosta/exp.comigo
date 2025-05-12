package br.com.comigo.atendimento.api.domain.util;

import java.util.regex.Pattern;

public record Telefone(String numero, TipoDeTelefone tipo) {

    private static final Pattern TELEFONE_PATTERN = Pattern.compile(
            "^\\(\\d{2}\\)[\\s-]?9\\d{4}[-\\s]?\\d{4}$");

    public Telefone {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Numero de Telefone não pode ser nulo ou vazio");
        }
        if (TELEFONE_PATTERN.matcher(numero).matches()) {

        } else
            throw new IllegalArgumentException("Telefone inválido");
    }
}