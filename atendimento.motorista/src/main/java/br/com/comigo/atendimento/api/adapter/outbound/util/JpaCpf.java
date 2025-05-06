package br.com.comigo.atendimento.api.adapter.outbound.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JpaCpf {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public JpaCpf() {
    }

    public JpaCpf(String cpf) {
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos numéricos");
        }
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    private static boolean isValidCpf(String cpf) {
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int sum1 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += (cpf.charAt(i) - '0') * (10 - i);
        }
        int checkDigit1 = 11 - (sum1 % 11);
        if (checkDigit1 >= 10) {
            checkDigit1 = 0;
        }

        if (checkDigit1 != (cpf.charAt(9) - '0')) {
            return false;
        }

        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += (cpf.charAt(i) - '0') * (11 - i);
        }
        int checkDigit2 = 11 - (sum2 % 11);
        if (checkDigit2 >= 10) {
            checkDigit2 = 0;
        }

        return checkDigit2 == (cpf.charAt(10) - '0');
    }
}