package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.cliente.JpaVeiculo;

public interface JpaVeiculoRepository extends JpaRepository<JpaVeiculo, Long> {
  
}