package br.com.comigo.atendimento.api.domain.projection;

public interface PrestadorSetupDeItemDeServicoProjection {
  Long getPrestadorId();
  String getPrestadorNome();
  String getPrestadorCnpj();
  String getPrestadorTelefoneNumero();
  String getPrestadorTelefoneTipo();
  String getPrestadorEmail();
  String getPrestadorEnderecoRua();
  String getPrestadorEnderecoNumero();
  String getPrestadorEnderecoComplemento();
  String getPrestadorEnderecoBairro();
  String getPrestadorEnderecoCidade();
  String getPrestadorEnderecoEstado();
  String getPrestadorEnderecoCep();
  String getSetupDeItemDeServicoStatus();
  Integer getSetupDeItemDeServicoPrecoUnitario();
  Long getSetupDeItemDeServicoItemDeServicoId();
}