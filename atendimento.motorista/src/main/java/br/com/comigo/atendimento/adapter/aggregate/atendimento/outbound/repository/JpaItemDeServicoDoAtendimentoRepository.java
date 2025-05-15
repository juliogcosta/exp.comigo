package br.com.comigo.atendimento.adapter.aggregate.atendimento.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.adapter.aggregate.atendimento.outbound.JpaItemDeServicoDoAtendimento;

public interface JpaItemDeServicoDoAtendimentoRepository extends JpaRepository<JpaItemDeServicoDoAtendimento, Long> {
  
}