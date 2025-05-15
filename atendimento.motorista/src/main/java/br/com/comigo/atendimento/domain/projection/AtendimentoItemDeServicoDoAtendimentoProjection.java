package br.com.comigo.atendimento.domain.projection;

import java.util.Date;

public interface AtendimentoItemDeServicoDoAtendimentoProjection {

    // Campos do atendimento
    Long getAtendimentoId();
    Long getPrestadorId();
    Long getClienteId();
    String getClienteNome();
    String getClienteTelefoneNumero();
    String getClienteTelefoneTipo();
    Long getVeiculoId();
    String getVeiculoPlaca();
    String getTipoOcorrencia();
    String getTipoServico();
    String getStatus();
    Date getDataHoraChamado();
    Date getDataHoraFinalizado();

    // Campos do item de serviço do atendimento
    Long getItemDeServicoId();
    Integer getQuantidade();
    Double getValorUnitario();
}