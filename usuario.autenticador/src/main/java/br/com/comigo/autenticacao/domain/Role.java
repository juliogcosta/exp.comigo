package br.com.comigo.autenticacao.domain;

import br.com.comigo.common.model.utils.SecRoleStatus;

public class Role {
    private String name;
    private SecRoleStatus status;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecRoleStatus getStatus() {
        return this.status;
    }

    public void setStatus(SecRoleStatus status) {
        this.status = status;
    }
}