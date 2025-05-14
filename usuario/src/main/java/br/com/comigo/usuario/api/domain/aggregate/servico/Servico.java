package br.com.comigo.usuario.api.domain.aggregate.servico;

import java.util.List;

import br.com.comigo.usuario.api.domain.util.StatusDeServico;

public class Servico {
    private Long id = null;
    private String nome = null;
    private String descricao;
    private StatusDeServico status = null;
    private List<ItemDeServico> itemDeServicos = null;

    public Servico(Long id, String nome, String descricao, StatusDeServico status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = StatusDeServico.ATIVO;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusDeServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusDeServico status) {
      this.status = status;
    }

    public void setItemDeServicos(List<ItemDeServico> itemDeServicos) {
      this.itemDeServicos = itemDeServicos;
    }

    public List<ItemDeServico> getItemDeServicos() {
      return itemDeServicos;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + getStatus() + "'" +
            ", itemDeServicos='" + getItemDeServicos() + "'" +
            "}";
    }

}