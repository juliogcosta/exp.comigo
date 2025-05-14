package br.com.comigo.usuario.api.mapper.aggregate.cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.VeiculoDTO;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaVeiculo;
import br.com.comigo.usuario.api.domain.aggregate.cliente.Veiculo;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "veiculoDTO.marca", target = "marca"),
                        @Mapping(source = "veiculoDTO.modelo", target = "modelo"),
                        @Mapping(source = "veiculoDTO.cor", target = "cor"),
                        @Mapping(source = "veiculoDTO.placa", target = "placa"),
                        @Mapping(source = "veiculoDTO.ano", target = "ano"),
                        @Mapping(target = "cliente", ignore = true)
        })
        Veiculo toDomain(VeiculoDTO veiculoDTO);

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "veiculo.marca", target = "marca"),
                        @Mapping(source = "veiculo.modelo", target = "modelo"),
                        @Mapping(source = "veiculo.cor", target = "cor"),
                        @Mapping(source = "veiculo.placa", target = "placa"),
                        @Mapping(source = "veiculo.ano", target = "ano")
        })
        VeiculoDTO toDto(Veiculo veiculo);

        @Mappings({
                        @Mapping(source = "jpaVeiculo.id", target = "id"),
                        @Mapping(source = "jpaVeiculo.marca", target = "marca"),
                        @Mapping(source = "jpaVeiculo.modelo", target = "modelo"),
                        @Mapping(source = "jpaVeiculo.cor", target = "cor"),
                        @Mapping(source = "jpaVeiculo.placa", target = "placa"),
                        @Mapping(source = "jpaVeiculo.ano", target = "ano"),
                        @Mapping(target = "cliente", ignore = true),
        })
        Veiculo fromJpaToDomain(JpaVeiculo jpaVeiculo);

        @Mappings({
                        @Mapping(target = "id", ignore = true),
                        @Mapping(source = "jpaVeiculo.marca", target = "marca"),
                        @Mapping(source = "jpaVeiculo.modelo", target = "modelo"),
                        @Mapping(source = "jpaVeiculo.cor", target = "cor"),
                        @Mapping(source = "jpaVeiculo.placa", target = "placa"),
                        @Mapping(source = "jpaVeiculo.ano", target = "ano")
        })
        VeiculoDTO fromJpaToDto(JpaVeiculo jpaVeiculo);
}
