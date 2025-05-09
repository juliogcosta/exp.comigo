package br.com.comigo.atendimento.api.mapper.aggregate.servico;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.dto.ServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.JpaServico;
import br.com.comigo.atendimento.api.domain.aggregate.servico.Servico;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    @Mappings({
        @Mapping(source = "servicoDTO.id", target = "id"),
        @Mapping(source = "servicoDTO.nome", target = "nome"),
        @Mapping(source = "servicoDTO.descricao", target = "descricao"),
        @Mapping(source = "servicoDTO.status", target = "status")
    })
    Servico toDomain(ServicoDTO servicoDTO);

    @Mappings({
        @Mapping(source = "servico.id", target = "id"),
        @Mapping(source = "servico.nome", target = "nome"),
        @Mapping(source = "servico.descricao", target = "descricao"),
        @Mapping(source = "servico.status", target = "status")
    })
    @SuppressWarnings("UnmappedTargetProperties")
    ServicoDTO toDto(Servico servico);

    @Mappings({
        @Mapping(source = "jpaServico.id", target = "id"),
        @Mapping(source = "jpaServico.nome", target = "nome"),
        @Mapping(source = "jpaServico.descricao", target = "descricao"),
        @Mapping(source = "jpaServico.status", target = "status")
    })
    Servico fromJpaToDomain(JpaServico jpaServico);

    @Mappings({
        @Mapping(source = "jpaServico.id", target = "id"),
        @Mapping(source = "jpaServico.nome", target = "nome"),
        @Mapping(source = "jpaServico.descricao", target = "descricao"),
        @Mapping(source = "jpaServico.status", target = "status")
    })
    ServicoDTO fromJpaToDto(JpaServico jpaServico);
}
