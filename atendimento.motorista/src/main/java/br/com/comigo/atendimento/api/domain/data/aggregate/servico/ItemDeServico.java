package br.com.comigo.atendimento.api.domain.data.aggregate.servico;

public class ItemDeServico {
    private Long id = null;
    private String nome = null;
    private String descricao = null;
    private String unidadeMedida = null;
    private Servico servico = null;
    
    public ItemDeServico(Long id, String nome, String descricao, String unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
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

    public String getDescricao() {
        return this.descricao;
    }

    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }

    public Servico getServico() {
        return this.servico;
    }

}