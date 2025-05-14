package br.com.comigo.usuario.api.mapper.aggregate.prestador;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.usuario.api.adapter.aggregate.prestador.dto.PrestadorDTO;
import br.com.comigo.usuario.api.adapter.aggregate.prestador.dto.SetupDeItemDoServicoDTO;
import br.com.comigo.usuario.api.adapter.aggregate.prestador.outbound.JpaPrestador;
import br.com.comigo.usuario.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.usuario.api.domain.aggregate.prestador.SetupDeItemDoServico;
import br.com.comigo.usuario.api.domain.util.Cnpj;
import br.com.comigo.usuario.api.domain.util.Email;
import br.com.comigo.usuario.api.domain.util.Endereco;
import br.com.comigo.usuario.api.domain.util.Telefone;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {

        @Mappings({
                        @Mapping(source = "prestadorDTO.id", target = "id"),
                        @Mapping(source = "prestadorDTO.nome", target = "nome"),
                        @Mapping(source = "prestadorDTO.cnpj", target = "cnpj"),
                        @Mapping(source = "prestadorDTO.telefone", target = "telefone"),
                        @Mapping(source = "prestadorDTO.whatsapp", target = "whatsapp"),
                        @Mapping(source = "prestadorDTO.email", target = "email"),
                        @Mapping(source = "prestadorDTO.endereco", target = "endereco"),
                        @Mapping(source = "prestadorDTO.status", target = "status"),
                        @Mapping(target = "setupDeItemDoServicos", ignore = true)
        })
        Prestador toDomain(PrestadorDTO prestadorDTO);

        @Mappings({
                        @Mapping(source = "prestador.id", target = "id"),
                        @Mapping(source = "prestador.nome", target = "nome"),
                        @Mapping(source = "prestador.cnpj", target = "cnpj"),
                        @Mapping(source = "prestador.telefone", target = "telefone"),
                        @Mapping(source = "prestador.whatsapp", target = "whatsapp"),
                        @Mapping(source = "prestador.email", target = "email"),
                        @Mapping(source = "prestador.endereco", target = "endereco"),
                        @Mapping(source = "prestador.status", target = "status")
        })
        PrestadorDTO toDto(Prestador prestador);

        default Prestador fromJpaToDomain(JpaPrestador jpaPrestador) {
                if (jpaPrestador == null) {
                        return null;
                }

                Cnpj cnpj = new Cnpj(jpaPrestador.getCnpj().getCnpj());

                Telefone telefone = new Telefone(jpaPrestador.getTelefone().getNumero(),
                                jpaPrestador.getTelefone().getTipo());

                Telefone whatsapp = new Telefone(jpaPrestador.getTelefone().getNumero(),
                                jpaPrestador.getTelefone().getTipo());

                Email email = new Email(jpaPrestador.getEmail().getEmail());

                Endereco endereco = new Endereco(
                                jpaPrestador.getEndereco().getLogradouro(),
                                jpaPrestador.getEndereco().getNumero(),
                                jpaPrestador.getEndereco().getComplemento(),
                                jpaPrestador.getEndereco().getBairro(),
                                jpaPrestador.getEndereco().getCidade(),
                                jpaPrestador.getEndereco().getEstado(),
                                jpaPrestador.getEndereco().getCep());

                List<SetupDeItemDoServico> setupDeItemDoServicos = new ArrayList<>();
                if (jpaPrestador.getSetupDeItemDoServicos() == null) {

                } else {
                        setupDeItemDoServicos = new ArrayList<>(jpaPrestador.getSetupDeItemDoServicos().stream()
                                        .map(setupDeItemDoServico -> new SetupDeItemDoServico(
                                                        setupDeItemDoServico.getId(),
                                                        setupDeItemDoServico.getPrecoUnitario(),
                                                        setupDeItemDoServico.getStatus(),
                                                        setupDeItemDoServico.getItemDeServicoId()))
                                        .toList());
                }

                Prestador prestador = new Prestador(
                                jpaPrestador.getId(),
                                jpaPrestador.getNome(),
                                cnpj,
                                telefone,
                                whatsapp,
                                email,
                                endereco);
                prestador.setSetupDeItemDoServicos(setupDeItemDoServicos);

                return prestador;
        }

        default PrestadorDTO fromJpaToDto(JpaPrestador jpaPrestador) {
                if (jpaPrestador == null) {
                        return null;
                }

                Cnpj cnpj = new Cnpj(jpaPrestador.getCnpj().getCnpj());

                Telefone telefone = new Telefone(jpaPrestador.getTelefone().getNumero(),
                                jpaPrestador.getTelefone().getTipo());

                Telefone whatsapp = new Telefone(jpaPrestador.getTelefone().getNumero(),
                                jpaPrestador.getTelefone().getTipo());

                Email email = new Email(jpaPrestador.getEmail().getEmail());

                Endereco endereco = new Endereco(
                                jpaPrestador.getEndereco().getLogradouro(),
                                jpaPrestador.getEndereco().getNumero(),
                                jpaPrestador.getEndereco().getComplemento(),
                                jpaPrestador.getEndereco().getBairro(),
                                jpaPrestador.getEndereco().getCidade(),
                                jpaPrestador.getEndereco().getEstado(),
                                jpaPrestador.getEndereco().getCep());

                List<SetupDeItemDoServicoDTO> setupDeItemDoServicoDTOs = new ArrayList<>();
                if (jpaPrestador.getSetupDeItemDoServicos() == null) {

                } else {
                        setupDeItemDoServicoDTOs = new ArrayList<>(jpaPrestador.getSetupDeItemDoServicos().stream()
                                        .map(setupDeItemDoServico -> new SetupDeItemDoServicoDTO(
                                                        setupDeItemDoServico.getId(),
                                                        setupDeItemDoServico.getPrecoUnitario(),
                                                        setupDeItemDoServico.getStatus(),
                                                        setupDeItemDoServico.getItemDeServicoId()))
                                        .toList());
                }

                return new PrestadorDTO(
                                jpaPrestador.getId(),
                                jpaPrestador.getNome(),
                                cnpj,
                                telefone,
                                whatsapp,
                                email,
                                endereco,
                                jpaPrestador.getStatus(),
                                setupDeItemDoServicoDTOs);
        }
}
