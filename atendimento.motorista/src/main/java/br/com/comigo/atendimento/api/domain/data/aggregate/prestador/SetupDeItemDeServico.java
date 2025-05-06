package br.com.comigo.atendimento.api.domain.data.aggregate.prestador;

import br.com.comigo.atendimento.api.domain.util.StatusDeSetupDeItemDeServico;

public class SetupDeItemDeServico {
    private Long id = null;
    private Integer precoUnitario = null;
    private StatusDeSetupDeItemDeServico status = null;
    private Long itemDeServicoId = null;
    private Prestador prestador = null;
    
    public SetupDeItemDeServico(Integer precoUnitario, Long itemDeServicoId) {
        this.precoUnitario = precoUnitario;
        this.status = StatusDeSetupDeItemDeServico.ATIVO;
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

    public StatusDeSetupDeItemDeServico getStatus() {
        return this.status;
    }

    public Long getItemDeServicoId() {
        return this.itemDeServicoId;
    }

    public Prestador getPrestador() {
        return this.prestador;
    }

}