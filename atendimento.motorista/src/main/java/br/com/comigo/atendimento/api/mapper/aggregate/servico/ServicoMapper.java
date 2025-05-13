package br.com.comigo.atendimento.api.mapper.aggregate.servico;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.dto.ItemDeServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.servico.dto.ServicoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.JpaServico;
import br.com.comigo.atendimento.api.domain.aggregate.servico.ItemDeServico;
import br.com.comigo.atendimento.api.domain.aggregate.servico.Servico;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    @Mappings({
        @Mapping(source = "servicoDTO.id", target = "id"),
        @Mapping(source = "servicoDTO.nome", target = "nome"),
        @Mapping(source = "servicoDTO.descricao", target = "descricao"),
        @Mapping(source = "servicoDTO.status", target = "status"),
        @Mapping(target = "itemDeServicos", ignore = true)
    })
    Servico toDomain(ServicoDTO servicoDTO);

    @Mappings({
        @Mapping(source = "servico.id", target = "id"),
        @Mapping(source = "servico.nome", target = "nome"),
        @Mapping(source = "servico.descricao", target = "descricao"),
        @Mapping(source = "servico.status", target = "status")
    })
    ServicoDTO toDto(Servico servico);

    default Servico fromJpaToDomain(JpaServico jpaServico) {
        if (jpaServico == null) {
                return null;
        }

        List<ItemDeServico> itemDeServicos = new ArrayList<>();
        if (jpaServico.getItemDeServicos() == null) {

        } else {
            itemDeServicos = jpaServico.getItemDeServicos().stream()
                .map(itemDeServicoServico -> new ItemDeServico(
                    itemDeServicoServico.getId(),
                    itemDeServicoServico.getNome(),
                    itemDeServicoServico.getDescricao(),
                    itemDeServicoServico.getUnidadeMedida()))
                .toList();
        }

        Servico servico = new Servico(
            jpaServico.getId(),
            jpaServico.getNome(),
            jpaServico.getNome(),
            jpaServico.getStatus());
        servico.setItemDeServicos(itemDeServicos);

        return servico;
    }

    default ServicoDTO fromJpaToDto(JpaServico jpaServico) {
        if (jpaServico == null) {
            return null;
        }

        List<ItemDeServicoDTO> itemDeServicoDTOs = new ArrayList<>();
        if (jpaServico.getItemDeServicos() == null) {

        } else {
            itemDeServicoDTOs = jpaServico.getItemDeServicos().stream()
                .map(itemDeServicoServico -> new ItemDeServicoDTO(
                    itemDeServicoServico.getId(),
                    itemDeServicoServico.getNome(),
                    itemDeServicoServico.getDescricao(),
                    itemDeServicoServico.getUnidadeMedida()))
                .toList();
        }

        ServicoDTO servico = new ServicoDTO(
            jpaServico.getId(),
            jpaServico.getNome(),
            jpaServico.getNome(),
            jpaServico.getStatus(), 
            itemDeServicoDTOs);

        return servico;
    }
}
