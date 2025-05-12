package br.com.comigo.atendimento.api.domain.util;

public record Cnpj(String valor) {

    public Cnpj {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("CNPJ não pode ser nulo ou vazio");
        }
        if (!valor.matches("\\d{14}")) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos numéricos");
        }
        if (!isValidCnpj(valor)) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
    }

    private static boolean isValidCnpj(String cnpj) {
        // Verifica se todos os dígitos são iguais (ex.: 11111111111111)
        if (cnpj.chars().distinct().count() == 1) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int[] weights1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum1 = 0;
        for (int i = 0; i < 12; i++) {
            sum1 += (cnpj.charAt(i) - '0') * weights1[i];
        }
        int checkDigit1 = 11 - (sum1 % 11);
        if (checkDigit1 >= 10) {
            checkDigit1 = 0;
        }

        // Verifica o primeiro dígito
        if (checkDigit1 != (cnpj.charAt(12) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        int[] weights2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int sum2 = 0;
        for (int i = 0; i < 13; i++) {
            sum2 += (cnpj.charAt(i) - '0') * weights2[i];
        }
        int checkDigit2 = 11 - (sum2 % 11);
        if (checkDigit2 >= 10) {
            checkDigit2 = 0;
        }

        // Verifica o segundo dígito
        return checkDigit2 == (cnpj.charAt(13) - '0');
    }
}