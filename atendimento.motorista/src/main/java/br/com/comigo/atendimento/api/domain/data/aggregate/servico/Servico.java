package br.com.comigo.atendimento.api.domain.data.aggregate.servico;

import br.com.comigo.atendimento.api.domain.util.StatusDeServico;

public class Servico {
    private String id = null;
    private String nome = null;
    private String descricao;
    private StatusDeServico status = null;

    public Servico(String id, String nome, String descricao, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = StatusDeServico.ATIVO;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public StatusDeServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusDeServico status) {
      this.status = status;
    }
}