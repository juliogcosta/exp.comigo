package br.com.comigo.atendimento.api.domain.aggregate.atendimento;

public class ItemDeServicoDoAtendimento {
  private Long id = null;
  private Long setupDeItemDoServicoId = null;
  private Integer quantidade = null;
  private String observacao = null;
  private Atendimento atendimento = null;

  public ItemDeServicoDoAtendimento(Long id, Long setupDeItemDoServicoId, Integer quantidade, Atendimento atendimento) {
    this.id = id;
    this.setupDeItemDoServicoId = setupDeItemDoServicoId;
    this.quantidade = quantidade;
    this.atendimento = atendimento;
  }

  public Long getId() {
    return id;
  }

  public Long getSetupDeItemDoServicoId() {
    return setupDeItemDoServicoId;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Atendimento getAtendimento() {
    return atendimento;
  }
}
