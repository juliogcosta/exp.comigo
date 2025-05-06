package br.com.comigo.atendimento.api.domain.projection;

public interface ServicoItemDeServicoProjection {
  String getIdServico();
  String getNomeServico();
  String getDescricaoServico();
  String getStatusServico();

  String getNomeItemDeServico();
  String getDescricaoItemDeServico();
  String getUnidadeMedidaItemDeServico();
  String getStatusItemDeServico();
}