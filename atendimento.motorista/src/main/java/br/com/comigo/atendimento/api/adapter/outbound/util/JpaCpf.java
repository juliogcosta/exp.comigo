package br.com.comigo.atendimento.api.adapter.outbound.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class JpaCpf {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public JpaCpf(String cpf) {
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}