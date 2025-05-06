package br.com.comigo.atendimento.api.adapter.outbound.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.outbound.entity.JpaAddress;
import br.com.comigo.atendimento.api.domain.data.Address;
import br.com.comigo.atendimento.api.domain.data.Event;
import br.com.comigo.atendimento.api.domain.repository.AddressRepository;
import br.com.comigo.atendimento.api.mapper.AddressMapper;

@Repository
public class AddressRepositoryImpl implements AddressRepository {
    private final JpaAddressRepository jpaAddressRepository;
    private final AddressMapper addressMapper;

    public AddressRepositoryImpl(JpaAddressRepository jpaAddressRepository, AddressMapper addressMapper) {
        this.jpaAddressRepository = jpaAddressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address save(Address address) {
        final JpaAddress jpaAddress = new JpaAddress(address);
        this.jpaAddressRepository.save(jpaAddress);
        return new Address(jpaAddress.getId(),
            jpaAddress.getCity(),
            jpaAddress.getState());
    }

    @Override
    public Optional<Address> findByEvent(Event event) {
        final Optional<JpaAddress> optional = this.jpaAddressRepository.findByJpaEvent_Id(event.getId());
        return optional.map(addressMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        this.jpaAddressRepository.deleteById(id);
    }
}