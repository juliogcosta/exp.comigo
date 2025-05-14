package br.com.comigo.usuario.api.domain.projection;

public interface ServicoItemDeServicoProjection {
  String getServicoId();
  String getServicoNome();
  String getServicoDescricao();
  String getServicoStatus();
  Long getItemDeServicoId();
  String getItemDeServicoNome();
  String getItemDeServicoDescricao();
  String getItemDeServicoUnidadeMedida();
}