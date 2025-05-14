package br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.JpaItemDeServico;

public interface JpaItemDeServicoRepository extends JpaRepository<JpaItemDeServico, Long> {
  
}