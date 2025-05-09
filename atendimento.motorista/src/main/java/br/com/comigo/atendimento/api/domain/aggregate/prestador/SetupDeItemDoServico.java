package br.com.comigo.atendimento.api.domain.aggregate.prestador;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDoServico;

public class SetupDeItemDoServico {
    private Long id = null;
    private Integer precoUnitario = null;
    private StatusDeSetupDeItemDoServico status = null;
    private Long itemDeServicoId = null;
    private Prestador prestador = null;
    
    public SetupDeItemDoServico(Long id, Integer precoUnitario, StatusDeSetupDeItemDoServico status, Long itemDeServicoId) {
        this.id = id;
        this.precoUnitario = precoUnitario;
        this.status = status;
        this.itemDeServicoId = itemDeServicoId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(Integer precoUnitario) {
      this.precoUnitario = precoUnitario;
    }

    public StatusDeSetupDeItemDoServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusDeSetupDeItemDoServico status) {
      this.status = status;
    }

    public Long getItemDeServicoId() {
        return this.itemDeServicoId;
    }

    public void setItemDeServicoId(Long itemDeServicoId) {
      this.itemDeServicoId = itemDeServicoId;
    }

    public Prestador getPrestador() {
        return this.prestador;
    }

    public void setPrestador(Prestador prestador) {
      this.prestador = prestador;
    }
}