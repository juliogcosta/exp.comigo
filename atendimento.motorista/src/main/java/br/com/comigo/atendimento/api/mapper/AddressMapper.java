package br.com.comigo.atendimento.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.inbound.dto.AddressRequestDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.AddressResponseDTO;
import br.com.comigo.atendimento.api.adapter.outbound.entity.JpaAddress;
import br.com.comigo.atendimento.api.domain.data.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "addressRequestDTO.city", target = "city"),
        @Mapping(source = "addressRequestDTO.state", target = "state"),
        @Mapping(target = "event", ignore = true)
    })
    @SuppressWarnings("UnmappedTargetProperties")
    Address toDomain(AddressRequestDTO addressRequestDTO);

    @Mappings({
        @Mapping(source = "address.city", target = "city"),
        @Mapping(source = "address.state", target = "state")
    })
    AddressRequestDTO toDto(Address address);

    @Mappings({
        @Mapping(source = "address.city", target = "city"),
        @Mapping(source = "address.state", target = "state")
    })
    AddressResponseDTO toResponseDto(Address address);

    @Mappings({
        @Mapping(source = "jpaAddress.city", target = "city"),
        @Mapping(source = "jpaAddress.state", target = "state"),
        @Mapping(source = "jpaAddress.id", target = "id"),
        @Mapping(target = "event", ignore = true)
    })
    Address toDomain(JpaAddress jpaAddress);
    
}