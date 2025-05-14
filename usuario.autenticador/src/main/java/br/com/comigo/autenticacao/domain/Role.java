package br.com.comigo.autenticacao.domain;

public class Role {
    private String name;
    private RoleStatus status;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleStatus getStatus() {
        return this.status;
    }

    public void setStatus(RoleStatus status) {
        this.status = status;
    }
}