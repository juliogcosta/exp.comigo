package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaSetupDeItemDoServico;

public interface JpaSetupDeItemDoServicoRepository extends JpaRepository<JpaSetupDeItemDoServico, Long> {
    
}