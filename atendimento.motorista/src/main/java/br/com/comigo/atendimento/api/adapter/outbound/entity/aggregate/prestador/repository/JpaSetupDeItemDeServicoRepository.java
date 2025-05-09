package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.prestador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.prestador.JpaSetupDeItemDeServico;

public interface JpaSetupDeItemDeServicoRepository extends JpaRepository<JpaSetupDeItemDeServico, Long> {
    
}