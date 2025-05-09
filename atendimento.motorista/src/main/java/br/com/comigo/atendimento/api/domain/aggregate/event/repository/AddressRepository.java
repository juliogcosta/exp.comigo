package br.com.comigo.atendimento.api.domain.aggregate.event.repository;

import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.event.Address;
import br.com.comigo.atendimento.api.domain.aggregate.event.Event;

public interface AddressRepository {
    Address save(Address address);

    Optional<Address> findByEvent(Event event);

    void deleteById(Long id);
}