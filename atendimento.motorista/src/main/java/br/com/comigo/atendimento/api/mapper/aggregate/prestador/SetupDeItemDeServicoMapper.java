package br.com.comigo.atendimento.api.mapper.aggregate.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.prestador.SetupDeItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.outbound.entity.aggregate.prestador.JpaSetupDeItemDeServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDeServico;

@Mapper(componentModel = "spring")
public interface SetupDeItemDeServicoMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "setupDeItemDeServicoDTO.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "setupDeItemDeServicoDTO.status", target = "status"),
        @Mapping(source = "setupDeItemDeServicoDTO.itemDeServicoId", target = "itemDeServicoId")
    })
    @SuppressWarnings("UnmappedTargetProperties")
    SetupDeItemDeServico toDomain(SetupDeItemDeServicoDTO setupDeItemDeServicoDTO);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "setupDeItemDeServicoDTO.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "setupDeItemDeServicoDTO.status", target = "status"),
        @Mapping(source = "setupDeItemDeServicoDTO.itemDeServicoId", target = "itemDeServicoId")
    })
    @SuppressWarnings("UnmappedTargetProperties")
    SetupDeItemDeServicoDTO toDto(SetupDeItemDeServico setupDeItemDeServicoDTO);

    @Mappings({
        @Mapping(source = "jpaSetupDeItemDeServico.id", target = "id"),
        @Mapping(source = "jpaSetupDeItemDeServico.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "jpaSetupDeItemDeServico.status", target = "status"),
        @Mapping(source = "jpaSetupDeItemDeServico.itemDeServicoId", target = "itemDeServicoId"),
        @Mapping(target = "prestador", ignore = true),
    })
    SetupDeItemDeServico fromJpaToDomain(JpaSetupDeItemDeServico jpaSetupDeItemDeServico);

    @Mappings({
        @Mapping(source = "jpaSetupDeItemDeServico.id", target = "id"),
        @Mapping(source = "jpaSetupDeItemDeServico.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "jpaSetupDeItemDeServico.status", target = "status"),
        @Mapping(source = "jpaSetupDeItemDeServico.itemDeServicoId", target = "itemDeServicoId")
    })
    SetupDeItemDeServicoDTO fromJpaToDto(SetupDeItemDeServico jpaSetupDeItemDeServico);
}
