package br.com.comigo.atendimento.adapter.aggregate.cliente.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.adapter.aggregate.cliente.outbound.JpaVeiculo;

public interface JpaVeiculoRepository extends JpaRepository<JpaVeiculo, Long> {
  
}