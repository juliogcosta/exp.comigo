package br.com.comigo.atendimento.api.domain.aggregate.atendimento;

public class ItemDeServicoDoAtendimento {
    private Long id = null;
    private Long setupDeItemDeServicoId = null;
    private Integer quantidade = null;
    private String observacao = null;
    private Atendimento atendimento = null;

    public ItemDeServicoDoAtendimento(Long id, Long setupDeItemDeServicoId, Integer quantidade, Atendimento atendimento) {
        this.id = id;
        this.setupDeItemDeServicoId = setupDeItemDeServicoId;
        this.quantidade = quantidade;
        this.atendimento = atendimento;
    }

    public Long getId() {
      return id;
    }

    public Long getSetupDeItemDeServicoId() {
      return setupDeItemDeServicoId;
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
  