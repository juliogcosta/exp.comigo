package br.com.comigo.atendimento.domain.aggregate.atendimento;

public class ItemDeServicoDoAtendimento {
  private Long id = null;
  private Long setupDeItemDoServicoId = null;
  private Integer quantidade = null;
  private String observacao = null;
  private Atendimento atendimento = null;

  public ItemDeServicoDoAtendimento(Long id, Long setupDeItemDoServicoId, Integer quantidade) {
    this.id = id;
    this.setupDeItemDoServicoId = setupDeItemDoServicoId;
    this.quantidade = quantidade;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSetupDeItemDoServicoId() {
    return this.setupDeItemDoServicoId;
  }

  public void setSetupDeItemDoServicoId(Long setupDeItemDoServicoId) {
    this.setupDeItemDoServicoId = setupDeItemDoServicoId;
  }

  public Integer getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public String getObservacao() {
    return this.observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Atendimento getAtendimento() {
    return this.atendimento;
  }

  public void setAtendimento(Atendimento atendimento) {
    this.atendimento = atendimento;
  }

  @Override
  public String toString() {
    return "ItemDeServicoDoAtendimento [id=" + id 
      + ", setupDeItemDoServicoId=" + setupDeItemDoServicoId
      + ", quantidade=" + quantidade 
      + ", observacao=" + observacao
      + "]";
  }
}
