package br.com.comigo.atendimento.api.adapter.aggregate.cliente.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVeiculoRepository extends JpaRepository<JpaVeiculo, Long> {
  
}