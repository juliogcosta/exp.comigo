package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaSetupDeItemDeServico;

public interface JpaSetupDeItemDeServicoRepository extends JpaRepository<JpaSetupDeItemDeServico, Long> {
    
}