package br.com.comigo.atendimento.mapper.aggregate.servico;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.adapter.aggregate.servico.dto.ItemDeServicoDTO;
import br.com.comigo.atendimento.adapter.aggregate.servico.outbound.JpaItemDeServico;
import br.com.comigo.atendimento.domain.aggregate.servico.ItemDeServico;

@Mapper(componentModel = "spring")
public interface ItemDeServicoMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "itemDeServicoDTO.nome", target = "nome"),
        @Mapping(source = "itemDeServicoDTO.descricao", target = "descricao"),
        @Mapping(source = "itemDeServicoDTO.unidadeMedida", target = "unidadeMedida"),
        @Mapping(target = "servico", ignore = true)
    })
    ItemDeServico toDomain(ItemDeServicoDTO itemDeServicoDTO);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "itemDeServico.nome", target = "nome"),
        @Mapping(source = "itemDeServico.descricao", target = "descricao"),
        @Mapping(source = "itemDeServico.unidadeMedida", target = "unidadeMedida")
    })
    ItemDeServicoDTO toDto(ItemDeServico itemDeServico);

    @Mappings({
        @Mapping(source = "jpaItemDeServico.id", target = "id"),
        @Mapping(source = "jpaItemDeServico.nome", target = "nome"),
        @Mapping(source = "jpaItemDeServico.descricao", target = "descricao"),
        @Mapping(source = "jpaItemDeServico.unidadeMedida", target = "unidadeMedida"),
        @Mapping(target = "servico", ignore = true),
    })
    ItemDeServico fromJpaToDomain(JpaItemDeServico jpaItemDeServico);

    @Mappings({
        @Mapping(source = "jpaItemDeServico.id", target = "id"),
        @Mapping(source = "jpaItemDeServico.nome", target = "nome"),
        @Mapping(source = "jpaItemDeServico.descricao", target = "descricao"),
        @Mapping(source = "jpaItemDeServico.unidadeMedida", target = "unidadeMedida")
    })
    ItemDeServicoDTO fromJpaToDto(JpaItemDeServico jpaItemDeServico);
}
