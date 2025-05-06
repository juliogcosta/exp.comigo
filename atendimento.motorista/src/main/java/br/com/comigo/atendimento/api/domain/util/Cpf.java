package br.com.comigo.atendimento.api.domain.util;

public record Cpf(String value) {

    public Cpf {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (!value.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos numéricos");
        }
        if (!isValidCpf(value)) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    private static boolean isValidCpf(String cpf) {
        // Verifica se todos os dígitos são iguais (ex.: 11111111111)
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum1 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += (cpf.charAt(i) - '0') * (10 - i);
        }
        int checkDigit1 = 11 - (sum1 % 11);
        if (checkDigit1 >= 10) {
            checkDigit1 = 0;
        }

        // Verifica o primeiro dígito
        if (checkDigit1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += (cpf.charAt(i) - '0') * (11 - i);
        }
        int checkDigit2 = 11 - (sum2 % 11);
        if (checkDigit2 >= 10) {
            checkDigit2 = 0;
        }

        // Verifica o segundo dígito
        return checkDigit2 == (cpf.charAt(10) - '0');
    }
}
