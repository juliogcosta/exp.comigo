package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.cliente.JpaCliente;
import br.com.comigo.atendimento.api.domain.projection.ClienteVeiculoProjection;

public interface JpaClienteRepository extends JpaRepository<JpaCliente, Long> {

  @Query("SELECT "
      + "c.id AS clienteId, "
      + "c.nome AS clienteNome, "
      + "c.cpf.cpf AS clienteCpf, "
      + "c.telefone.numero AS clienteTelefoneNumero, "
      + "c.telefone.tipo AS clienteTelefoneTipo, "
      + "c.whatsapp.numero AS clienteWhatsappNumero, "
      + "c.whatsapp.tipo AS clienteWhatsappTipo, "
      + "c.endereco AS clienteEndereco, "
      + "c.dataNascimento AS clienteDataNascimento, "
      + "v.id AS veiculoId, "
      + "v.placa AS veiculoPlaca, "
      + "v.modelo AS veiculoModelo, "
      + "v.marca AS veiculoMarca, "
      + "v.ano AS veiculoAno, "
      + "v.cor AS veiculoCor "
    + "FROM JpaCliente c LEFT JOIN JpaVeiculo v ON c.id = v.cliente.id " 
    + "WHERE c.cpf.cpf = :cpf")
    Page<ClienteVeiculoProjection> findVeiculoByClienteCpf(@Param("cpf") String cpf);
}