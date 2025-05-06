package br.com.comigo.atendimento.api.application.service;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.inbound.dto.AddressRequestDTO;
import br.com.comigo.atendimento.api.adapter.outbound.entity.JpaEvent;
import br.com.comigo.atendimento.api.adapter.outbound.repository.JpaEventRepository;
import br.com.comigo.atendimento.api.domain.data.Address;
import br.com.comigo.atendimento.api.domain.data.Event;
import br.com.comigo.atendimento.api.domain.repository.AddressRepository;
import br.com.comigo.atendimento.api.mapper.AddressMapper;
import br.com.comigo.atendimento.api.mapper.EventMapper;

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
