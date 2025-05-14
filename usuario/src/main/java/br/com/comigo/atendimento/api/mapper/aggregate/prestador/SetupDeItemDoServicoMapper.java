package br.com.comigo.atendimento.api.mapper.aggregate.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.SetupDeItemDoServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaSetupDeItemDoServico;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.SetupDeItemDoServico;

@Mapper(componentModel = "spring")
public interface SetupDeItemDoServicoMapper {

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "setupDeItemDoServicoDTO.precoUnitario", target = "precoUnitario"),
                        @Mapping(source = "setupDeItemDoServicoDTO.status", target = "status"),
                        @Mapping(source = "setupDeItemDoServicoDTO.itemDeServicoId", target = "itemDeServicoId"),
                        @Mapping(target = "prestador", ignore = true)
        })
        SetupDeItemDoServico toDomain(SetupDeItemDoServicoDTO setupDeItemDoServicoDTO);

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "setupDeItemDoServicoDTO.precoUnitario", target = "precoUnitario"),
                        @Mapping(source = "setupDeItemDoServicoDTO.status", target = "status"),
                        @Mapping(source = "setupDeItemDoServicoDTO.itemDeServicoId", target = "itemDeServicoId")
        })
        SetupDeItemDoServicoDTO toDto(SetupDeItemDoServico setupDeItemDoServicoDTO);

        @Mappings({
                        @Mapping(source = "jpaSetupDeItemDoServico.id", target = "id"),
                        @Mapping(source = "jpaSetupDeItemDoServico.precoUnitario", target = "precoUnitario"),
                        @Mapping(source = "jpaSetupDeItemDoServico.status", target = "status"),
                        @Mapping(source = "jpaSetupDeItemDoServico.itemDeServicoId", target = "itemDeServicoId"),
                        @Mapping(target = "prestador", ignore = true),
        })
        SetupDeItemDoServico fromJpaToDomain(JpaSetupDeItemDoServico jpaSetupDeItemDoServico);

        @Mappings({
                        @Mapping(source = "jpaSetupDeItemDoServico.id", target = "id"),
                        @Mapping(source = "jpaSetupDeItemDoServico.precoUnitario", target = "precoUnitario"),
                        @Mapping(source = "jpaSetupDeItemDoServico.status", target = "status"),
                        @Mapping(source = "jpaSetupDeItemDoServico.itemDeServicoId", target = "itemDeServicoId")
        })
        SetupDeItemDoServicoDTO fromJpaToDto(SetupDeItemDoServico jpaSetupDeItemDoServico);
}
