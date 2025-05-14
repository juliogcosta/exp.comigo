package br.com.comigo.usuario.api.mapper.aggregate.atendimento;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.usuario.api.adapter.aggregate.atendimento.dto.ItemDeServicoDoAtendimentoDTO;
import br.com.comigo.usuario.api.adapter.aggregate.atendimento.outbound.JpaItemDeServicoDoAtendimento;
import br.com.comigo.usuario.api.domain.aggregate.atendimento.ItemDeServicoDoAtendimento;

@Mapper(componentModel = "spring")
public interface ItemDeServicoDoAtendimentoMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "itemDeServicoDoAtendimentoDTO.setupDeItemDoServicoId", target = "setupDeItemDoServicoId"),
        @Mapping(source = "itemDeServicoDoAtendimentoDTO.quantidade", target = "quantidade"),
        @Mapping(source = "itemDeServicoDoAtendimentoDTO.observacao", target = "observacao"),
        @Mapping(target = "atendimento", ignore = true)
    })
    ItemDeServicoDoAtendimento toDomain(ItemDeServicoDoAtendimentoDTO itemDeServicoDoAtendimentoDTO);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "itemDeServicoDoAtendimento.setupDeItemDoServicoId", target = "setupDeItemDoServicoId"),
        @Mapping(source = "itemDeServicoDoAtendimento.quantidade", target = "quantidade"),
        @Mapping(source = "itemDeServicoDoAtendimento.observacao", target = "observacao")
    })
    ItemDeServicoDoAtendimentoDTO toDto(ItemDeServicoDoAtendimento itemDeServicoDoAtendimento);

    @Mappings({
        @Mapping(source = "jpaItemDeServicoDoAtendimento.id", target = "id"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.setupDeItemDoServicoId", target = "setupDeItemDoServicoId"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.quantidade", target = "quantidade"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.observacao", target = "observacao"),
        @Mapping(target = "atendimento", ignore = true),
    })
    ItemDeServicoDoAtendimento fromJpaToDomain(JpaItemDeServicoDoAtendimento jpaItemDeServicoDoAtendimento);

    @Mappings({
        @Mapping(source = "jpaItemDeServicoDoAtendimento.id", target = "id"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.setupDeItemDoServicoId", target = "setupDeItemDoServicoId"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.quantidade", target = "quantidade"),
        @Mapping(source = "jpaItemDeServicoDoAtendimento.observacao", target = "observacao")
    })
    ItemDeServicoDoAtendimentoDTO fromJpaToDto(JpaItemDeServicoDoAtendimento jpaItemDeServicoDoAtendimento);
}
