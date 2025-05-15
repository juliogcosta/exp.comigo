package br.com.comigo.atendimento.domain.aggregate.servico;

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

    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
      this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
      this.unidadeMedida = unidadeMedida;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico) {
      this.servico = servico;
    }

    @Override
    public String toString() {
        return "ItemDeServico [id=" + id 
            + ", nome=" + nome 
            + ", descricao=" + descricao 
            + ", unidadeMedida=" + unidadeMedida + "]";
    }
}