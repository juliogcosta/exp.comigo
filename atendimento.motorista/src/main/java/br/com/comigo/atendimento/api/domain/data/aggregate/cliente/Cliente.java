package br.com.comigo.atendimento.api.domain.data.aggregate.cliente;

import java.util.Date;

import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

public class Cliente {
    private Long id;
    private String nome;
    private Cpf cpf;
    private Telefone telefone;
    private Telefone whatsapp;
    private Email email;
    private Endereco endereco;
    private Date dataNascimento;
    
    public Cliente(String nome, Cpf cpf, Telefone telefone, Endereco endereco, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
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

    public Cpf getCpf() {
        return this.cpf;
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

    public Endereco getEndereco() {
        return this.endereco;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}