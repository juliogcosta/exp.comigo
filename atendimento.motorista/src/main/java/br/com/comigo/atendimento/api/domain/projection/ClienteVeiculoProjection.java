package br.com.comigo.atendimento.api.domain.projection;

public interface ClienteVeiculoProjection {
  Long getId();
  String getNome();
  String getCpf();
  String getTelefone();
  String getMarca();
  String getModelo();
  String getPlaca();
}