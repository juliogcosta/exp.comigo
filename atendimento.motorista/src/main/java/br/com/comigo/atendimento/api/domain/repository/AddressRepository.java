package br.com.comigo.atendimento.api.domain.repository;

import java.util.Optional;

import br.com.comigo.atendimento.api.domain.data.Address;
import br.com.comigo.atendimento.api.domain.data.Event;

public interface AddressRepository {
    Address save(Address address);

    Optional<Address> findByEvent(Event event);

    void deleteById(Long id);
}