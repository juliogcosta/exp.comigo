package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.servico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.servico.JpaItemDeServico;

public interface JpaItemDeServicoRepository extends JpaRepository<JpaItemDeServico, Long> {
  
}