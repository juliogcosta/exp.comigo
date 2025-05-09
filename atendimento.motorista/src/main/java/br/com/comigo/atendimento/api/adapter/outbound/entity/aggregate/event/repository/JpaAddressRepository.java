package br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.event.JpaAddress;

import java.util.Optional;

public interface JpaAddressRepository extends JpaRepository<JpaAddress, Long> {
    Optional<JpaAddress> findByJpaEvent_Id(Long eventId);
}
