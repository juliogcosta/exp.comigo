package br.com.comigo.atendimento.api.mapper.aggregate.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.SetupDeItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaSetupDeItemDoServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDoServico;

@Mapper(componentModel = "spring")
public interface SetupDeItemDoServicoMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "setupDeItemDeServicoDTO.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "setupDeItemDeServicoDTO.status", target = "status"),
        @Mapping(source = "setupDeItemDeServicoDTO.itemDeServicoId", target = "itemDeServicoId"),
        @Mapping(target = "prestador", ignore = true)
    })
    SetupDeItemDoServico toDomain(SetupDeItemDeServicoDTO setupDeItemDeServicoDTO);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "setupDeItemDeServicoDTO.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "setupDeItemDeServicoDTO.status", target = "status"),
        @Mapping(source = "setupDeItemDeServicoDTO.itemDeServicoId", target = "itemDeServicoId")
    })
    SetupDeItemDeServicoDTO toDto(SetupDeItemDoServico setupDeItemDeServicoDTO);

    @Mappings({
        @Mapping(source = "jpaSetupDeItemDeServico.id", target = "id"),
        @Mapping(source = "jpaSetupDeItemDeServico.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "jpaSetupDeItemDeServico.status", target = "status"),
        @Mapping(source = "jpaSetupDeItemDeServico.itemDeServicoId", target = "itemDeServicoId"),
        @Mapping(target = "prestador", ignore = true),
    })
    SetupDeItemDoServico fromJpaToDomain(JpaSetupDeItemDoServico jpaSetupDeItemDeServico);

    @Mappings({
        @Mapping(source = "jpaSetupDeItemDeServico.id", target = "id"),
        @Mapping(source = "jpaSetupDeItemDeServico.precoUnitario", target = "precoUnitario"),
        @Mapping(source = "jpaSetupDeItemDeServico.status", target = "status"),
        @Mapping(source = "jpaSetupDeItemDeServico.itemDeServicoId", target = "itemDeServicoId")
    })
    SetupDeItemDeServicoDTO fromJpaToDto(SetupDeItemDoServico jpaSetupDeItemDeServico);
}
