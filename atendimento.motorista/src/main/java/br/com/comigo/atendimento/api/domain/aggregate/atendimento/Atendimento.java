package br.com.comigo.atendimento.api.domain.aggregate.atendimento;

import java.security.Timestamp;

import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;
import br.com.comigo.atendimento.api.domain.util.Telefone;

public class Atendimento {
    private Long id;
    private Long prestadorId;
    private Long clienteId;
    private String clienteNome;
    private Telefone clienteTelefone;
    private Telefone clienteWhatsapp;
    private Long veiculoId;
    private String veiculoPlaca;
    private String tipoOcorrencia;
    private StatusDeAtendimento status;
    private Timestamp dataHoraChamado;
    private Timestamp dataHoraConfirmado;
    private Timestamp dataHoraEmAndamento;
    private Timestamp dataHoraFinalizado;
    private Timestamp dataHoraCancelado;
    private String descricao;
    private Endereco origem;
    private Endereco destino;
    private Endereco base;

    public Atendimento(Long id, String clienteNome, Telefone clienteTelefone,
            Telefone clienteWhatsapp, String veiculoPlaca, String tipoOcorrencia,
            Timestamp dataHoraChamado, Endereco origem, Endereco base) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.clienteTelefone = clienteTelefone;
        this.clienteWhatsapp = clienteWhatsapp;
        this.veiculoPlaca = veiculoPlaca;
        this.tipoOcorrencia = tipoOcorrencia;
        this.status = StatusDeAtendimento.CHAMADO;
        this.dataHoraChamado = dataHoraChamado;
        this.origem = origem;
        this.base = base;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrestadorId() {
      return this.prestadorId;
    }

    public void setPrestadorId(Long prestadorId) {
      this.prestadorId = prestadorId;
    }

    public String getClienteNome() {
        return this.clienteNome;
    }

    public Telefone getClienteTelefone() {
        return this.clienteTelefone;
    }

    public Telefone getClienteWhatsapp() {
        return this.clienteWhatsapp;
    }

    public Long getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getVeiculoPlaca() {
        return this.veiculoPlaca;
    }

    public Long getVeiculoId() {
        return this.veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getTipoOcorrencia() {
        return this.tipoOcorrencia;
    }

    public StatusDeAtendimento getStatus() {
        return this.status;
    }

    public void setStatus(StatusDeAtendimento status) {
      this.status = status;
    }

    public Timestamp getDataHoraChamado() {
        return this.dataHoraChamado;
    }

    public void setDataHoraChamado(Timestamp dataHoraChamado) {
        this.dataHoraChamado = dataHoraChamado;
    }

    public Timestamp getDataHoraConfirmado() {
        return this.dataHoraConfirmado;
    }

    public void setDataHoraConfirmado(Timestamp dataHoraConfirmado) {
        this.dataHoraConfirmado = dataHoraConfirmado;
    }

    public Timestamp getDataHoraEmAndamento() {
        return this.dataHoraEmAndamento;
    }

    public void setDataHoraEmAndamento(Timestamp dataHoraEmAndamento) {
        this.dataHoraEmAndamento = dataHoraEmAndamento;
    }

    public Timestamp getDataHoraFinalizado() {
        return this.dataHoraFinalizado;
    }

    public void setDataHoraFinalizado(Timestamp dataHoraFinalizado) {
        this.dataHoraFinalizado = dataHoraFinalizado;
    }

    public Timestamp getDataHoraCancelado() {
      return dataHoraCancelado;
    }

    public void setDataHoraCancelado(Timestamp dataHoraCancelado) {
      this.dataHoraCancelado = dataHoraCancelado;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getOrigem() {
        return this.origem;
    }

    public Endereco getDestino() {
        return this.destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }

    public Endereco getBase() {
        return this.base;
    }

}