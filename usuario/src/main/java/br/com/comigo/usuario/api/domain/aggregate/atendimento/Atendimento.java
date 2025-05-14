package br.com.comigo.usuario.api.domain.aggregate.atendimento;

import java.sql.Timestamp;
import java.util.List;

import br.com.comigo.usuario.api.domain.util.Endereco;
import br.com.comigo.usuario.api.domain.util.StatusDeAtendimento;
import br.com.comigo.usuario.api.domain.util.Telefone;

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
    private String tipoServico;
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
    private List<ItemDeServicoDoAtendimento> itemDeServicoDoAtendimentos;

    public Atendimento(Long id, String clienteNome, Telefone clienteTelefone,
            Telefone clienteWhatsapp, Long veiculoId, String veiculoPlaca, String tipoOcorrencia,
            String tipoServico, Endereco origem, Endereco destino, Endereco base) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.clienteTelefone = clienteTelefone;
        this.clienteWhatsapp = clienteWhatsapp;
        this.veiculoId = veiculoId;
        this.veiculoPlaca = veiculoPlaca;
        this.tipoOcorrencia = tipoOcorrencia;
        this.tipoServico = tipoServico;
        this.status = StatusDeAtendimento.CHAMADO;
        this.dataHoraChamado = new Timestamp(System.currentTimeMillis());
        this.origem = origem;
        this.base = base;
        this.destino = destino;
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

    public Long getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return this.clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public Telefone getClienteTelefone() {
        return this.clienteTelefone;
    }

    public void setClienteTelefone(Telefone clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public Telefone getClienteWhatsapp() {
        return this.clienteWhatsapp;
    }

    public void setClienteWhatsapp(Telefone clienteWhatsapp) {
        this.clienteWhatsapp = clienteWhatsapp;
    }

    public Long getVeiculoId() {
        return this.veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getVeiculoPlaca() {
        return this.veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public String getTipoOcorrencia() {
        return this.tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public String getTipoServico() {
      return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
      this.tipoServico = tipoServico;
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
        return this.dataHoraCancelado;
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

    public void setOrigem(Endereco origem) {
        this.origem = origem;
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

    public void setBase(Endereco base) {
        this.base = base;
    }

    public List<ItemDeServicoDoAtendimento> getItemDeServicoDoAtendimentos() {
      return itemDeServicoDoAtendimentos;
    }

    public void setItemDeServicoDoAtendimentos(List<ItemDeServicoDoAtendimento> itemDeServicoDoAtendimentos) {
      this.itemDeServicoDoAtendimentos = itemDeServicoDoAtendimentos;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", prestadorId='" + getPrestadorId() + "'" +
            ", clienteId='" + getClienteId() + "'" +
            ", clienteNome='" + getClienteNome() + "'" +
            ", clienteTelefone='" + getClienteTelefone() + "'" +
            ", clienteWhatsapp='" + getClienteWhatsapp() + "'" +
            ", veiculoId='" + getVeiculoId() + "'" +
            ", veiculoPlaca='" + getVeiculoPlaca() + "'" +
            ", tipoOcorrencia='" + getTipoOcorrencia() + "'" +
            ", status='" + getStatus() + "'" +
            ", dataHoraChamado='" + getDataHoraChamado() + "'" +
            ", dataHoraConfirmado='" + getDataHoraConfirmado() + "'" +
            ", dataHoraEmAndamento='" + getDataHoraEmAndamento() + "'" +
            ", dataHoraFinalizado='" + getDataHoraFinalizado() + "'" +
            ", dataHoraCancelado='" + getDataHoraCancelado() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", origem='" + getOrigem() + "'" +
            ", destino='" + getDestino() + "'" +
            ", base='" + getBase() + "'" +
            ", itemDeServicos='" + getItemDeServicoDoAtendimentos() + "'" +
            "}";
    }

}