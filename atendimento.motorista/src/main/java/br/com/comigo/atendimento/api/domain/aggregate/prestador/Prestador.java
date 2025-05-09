package br.com.comigo.atendimento.api.domain.aggregate.prestador;

import br.com.comigo.atendimento.api.domain.util.Cnpj;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.StatusDePrestador;
import br.com.comigo.atendimento.api.domain.util.Telefone;

public class Prestador {
    private Long id;
    private String nome;
    private Cnpj cnpj;
    private Telefone telefone;
    private Telefone whatsapp;
    private Email email;
    private Endereco endereco;
    private StatusDePrestador status;

    public Prestador(Long id, String nome, Cnpj cnpj, Telefone telefone, Telefone whatsapp, Email email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
        this.email = email;
        this.endereco = endereco;
        this.status = StatusDePrestador.ATIVO;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public Cnpj getCnpj() {
        return this.cnpj;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }

    public Telefone getWhatsapp() {
        return this.whatsapp;
    }

    public void setWhatsapp(Telefone whatsapp) {
      this.whatsapp = whatsapp;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public StatusDePrestador getStatus() {
      return status;
    }

    public void setStatus(StatusDePrestador status) {
      this.status = status;
    }
}