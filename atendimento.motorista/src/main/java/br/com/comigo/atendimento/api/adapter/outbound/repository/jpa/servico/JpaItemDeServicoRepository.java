package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.servico;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.servico.JpaItemDeServico;

public interface JpaItemDeServicoRepository extends JpaRepository<JpaItemDeServico, Long> {
  
}