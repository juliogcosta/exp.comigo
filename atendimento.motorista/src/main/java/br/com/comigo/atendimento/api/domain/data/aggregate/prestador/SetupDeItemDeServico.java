package br.com.comigo.atendimento.api.domain.data.aggregate.prestador;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDeServico;

public class SetupDeItemDeServico {
    private Long id = null;
    private Integer precoUnitario = null;
    private StatusDeSetupDeItemDeServico status = null;
    private Long itemDeServicoId = null;
    private Prestador prestador = null;
    
    public SetupDeItemDeServico(Long id, Integer precoUnitario, StatusDeSetupDeItemDeServico status, Long itemDeServicoId) {
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

    public StatusDeSetupDeItemDeServico getStatus() {
        return this.status;
    }

    public void setStatus(StatusDeSetupDeItemDeServico status) {
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