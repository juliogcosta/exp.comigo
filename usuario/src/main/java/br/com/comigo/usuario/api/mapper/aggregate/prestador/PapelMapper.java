package br.com.comigo.usuario.api.mapper.aggregate.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.usuario.api.adapter.aggregate.prestador.dto.PapelDTO;
import br.com.comigo.usuario.api.adapter.aggregate.prestador.outbound.JpaPapel;
import br.com.comigo.usuario.api.domain.aggregate.prestador.Papel;

@Mapper(componentModel = "spring")
public interface PapelMapper {

        @Mappings({
                        @Mapping(source = "papelDTO.id", target = "id"),
                        @Mapping(source = "papelDTO.nome", target = "nome"),
                        @Mapping(source = "papelDTO.status", target = "status")
        })
        Papel toDomain(PapelDTO papelDTO);

        @Mappings({
                        @Mapping(source = "papel.id", target = "id"),
                        @Mapping(source = "papel.nome", target = "nome"),
                        @Mapping(source = "papel.status", target = "status")
        })
        PapelDTO toDto(Papel papel);

        @Mappings({
                        @Mapping(source = "jpaPapel.id", target = "id"),
                        @Mapping(source = "jpaPapel.nome", target = "nome"),
                        @Mapping(source = "jpaPapel.status", target = "status"),
        })
        Papel fromJpaToDomain(JpaPapel jpaPapel);

        @Mappings({
                        @Mapping(source = "jpaPapel.id", target = "id"),
                        @Mapping(source = "jpaPapel.nome", target = "nome"),
                        @Mapping(source = "jpaPapel.status", target = "status"),
        })
        PapelDTO fromJpaToDto(JpaPapel jpaPapel);
}
