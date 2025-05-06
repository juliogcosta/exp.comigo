package br.com.comigo.atendimento.api.domain.projection;

public interface PrestadorSetupDeItemDeServicoProjection {
  String getNomePrestador();
  String getCnpjPrestador();
  String getTelefonePrestador();
  String getEmailPrestador();
  String getEnderecoPrestador();
  String getPrecoUnitarioSetupDeItemDeServico();
  String getItemDeServicoIdSetupDeItemDeServico(); 
}