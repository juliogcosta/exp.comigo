package br.com.comigo.atendimento.api.application.aggregate.service.event;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.aggregate.event.dto.AddressRequestDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.event.outbound.JpaEvent;
import br.com.comigo.atendimento.api.adapter.aggregate.event.outbound.repository.JpaEventRepository;
import br.com.comigo.atendimento.api.domain.aggregate.event.Address;
import br.com.comigo.atendimento.api.domain.aggregate.event.Event;
import br.com.comigo.atendimento.api.domain.aggregate.event.repository.AddressRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.event.AddressMapper;
import br.com.comigo.atendimento.api.mapper.aggregate.event.EventMapper;

import java.util.Optional;

@Service
public class AddressServiceImpl {

    private final JpaEventRepository eventRepository;
    private final AddressRepository addressRepository;
    private final EventMapper eventMapper;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(JpaEventRepository eventRepository, AddressRepository addressRepository, EventMapper eventMapper, AddressMapper addressMapper) {
        this.eventRepository = eventRepository;
        this.addressRepository = addressRepository;
        this.eventMapper = eventMapper;
        this.addressMapper = addressMapper;
    }

    public Address addAddressToEvent(Long eventId, AddressRequestDTO addressData) {
        JpaEvent jpaEvent = eventRepository.findById(eventId)
            .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Address address = this.addressMapper.toDomain(addressData);
        address.setEvent(this.eventMapper.toDomain(jpaEvent));
        return addressRepository.save(address);
    }

    public Optional<Address> findByEvent(Event event) {
        return addressRepository.findByEvent(event);
    }
}
