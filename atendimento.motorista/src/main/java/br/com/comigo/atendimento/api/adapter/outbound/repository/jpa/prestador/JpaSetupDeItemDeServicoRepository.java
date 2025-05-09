package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.prestador;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.prestador.JpaSetupDeItemDeServico;

public interface JpaSetupDeItemDeServicoRepository extends JpaRepository<JpaSetupDeItemDeServico, Long> {
    
}