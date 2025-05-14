package br.com.comigo.usuario.api.mapper.aggregate.cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.PapelDeUsuarioDTO;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaPapelDeUsuario;
import br.com.comigo.usuario.api.domain.aggregate.cliente.PapelDeUsuario;

@Mapper(componentModel = "spring")
public interface PapelDeUsuarioMapper {

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "papelDeUsuarioDTO.papelId", target = "papelId"),
                        @Mapping(target = "usuario", ignore = true)
        })
        PapelDeUsuario toDomain(PapelDeUsuarioDTO papelDeUsuarioDTO);

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "papelDeUsuario.papelId", target = "papelId")
        })
        PapelDeUsuarioDTO toDto(PapelDeUsuario papelDeUsuario);

        @Mappings({
                        @Mapping(source = "jpaPapelDeUsuario.id", target = "id"),
                        @Mapping(source = "jpaPapelDeUsuario.papelId", target = "papelId"),
                        @Mapping(target = "usuario", ignore = true),
        })
        PapelDeUsuario fromJpaToDomain(JpaPapelDeUsuario jpaPapelDeUsuario);

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "jpaPapelDeUsuario.papelId", target = "papelId")
        })
        PapelDeUsuarioDTO fromJpaToDto(JpaPapelDeUsuario jpaPapelDeUsuario);
}
