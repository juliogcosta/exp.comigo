package br.com.comigo.atendimento.domain.aggregate.cliente;

public class Veiculo {
  private Long id;
  private String marca;
  private String modelo;
  private String cor;
  private String placa;
  private String ano;
  private Cliente cliente;

  public Veiculo(Long id, String marca, String modelo, String cor, String ano, String placa) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
    this.ano = ano;
    this.placa = placa;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }

  public String getCor() {
    return cor;
  }

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public String getPlaca() {
    return placa;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}