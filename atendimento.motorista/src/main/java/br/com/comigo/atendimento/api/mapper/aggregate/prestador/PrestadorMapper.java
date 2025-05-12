package br.com.comigo.atendimento.api.mapper.aggregate.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.dto.PrestadorDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaPrestador;
import br.com.comigo.atendimento.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.atendimento.api.domain.util.Cnpj;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

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
            @Mapping(source = "prestadorDTO.status", target = "status")
    })
    @SuppressWarnings("UnmappedTargetProperties")
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
    @SuppressWarnings("UnmappedTargetProperties")
    PrestadorDTO toDto(Prestador prestador);

    default Prestador fromJpaToDomain(JpaPrestador jpaPrestador) {
        if (jpaPrestador == null) {
            return null;
        }

        Cnpj cnpj = new Cnpj(jpaPrestador.getCnpj().getCnpj());

        Telefone telefone = new Telefone(jpaPrestador.getTelefone().getNumero(), jpaPrestador.getTelefone().getTipo());

        Telefone whatsapp = new Telefone(jpaPrestador.getTelefone().getNumero(), jpaPrestador.getTelefone().getTipo());

        Email email = new Email(jpaPrestador.getEmail().getEmail());

        Endereco endereco = new Endereco(
                jpaPrestador.getEndereco().getLogradouro(),
                jpaPrestador.getEndereco().getNumero(),
                jpaPrestador.getEndereco().getComplemento(),
                jpaPrestador.getEndereco().getBairro(),
                jpaPrestador.getEndereco().getCidade(),
                jpaPrestador.getEndereco().getEstado(),
                jpaPrestador.getEndereco().getCep());

        return new Prestador(
                jpaPrestador.getId(),
                jpaPrestador.getNome(),
                cnpj,
                telefone,
                whatsapp,
                email,
                endereco);
    }

    default PrestadorDTO fromJpaToDto(JpaPrestador jpaPrestador) {
        if (jpaPrestador == null) {
            return null;
        }

        Cnpj cnpj = new Cnpj(jpaPrestador.getCnpj().getCnpj());

        Telefone telefone = new Telefone(jpaPrestador.getTelefone().getNumero(), jpaPrestador.getTelefone().getTipo());

        Telefone whatsapp = new Telefone(jpaPrestador.getTelefone().getNumero(), jpaPrestador.getTelefone().getTipo());

        Email email = new Email(jpaPrestador.getEmail().getEmail());

        Endereco endereco = new Endereco(
                jpaPrestador.getEndereco().getLogradouro(),
                jpaPrestador.getEndereco().getNumero(),
                jpaPrestador.getEndereco().getComplemento(),
                jpaPrestador.getEndereco().getBairro(),
                jpaPrestador.getEndereco().getCidade(),
                jpaPrestador.getEndereco().getEstado(),
                jpaPrestador.getEndereco().getCep());

        return new PrestadorDTO(
                jpaPrestador.getId(),
                jpaPrestador.getNome(),
                cnpj,
                telefone,
                whatsapp,
                email,
                endereco,
                jpaPrestador.getStatus());
    }
}
