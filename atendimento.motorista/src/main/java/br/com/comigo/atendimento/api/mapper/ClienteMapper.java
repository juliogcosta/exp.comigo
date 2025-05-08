package br.com.comigo.atendimento.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.cliente.ClienteDTO;
import br.com.comigo.atendimento.api.adapter.outbound.aggregate.cliente.JpaCliente;
import br.com.comigo.atendimento.api.domain.data.aggregate.cliente.Cliente;
import br.com.comigo.atendimento.api.domain.util.Cpf;
import br.com.comigo.atendimento.api.domain.util.Email;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mappings({
        @Mapping(source = "clienteDTO.id", target = "id"),
        @Mapping(source = "clienteDTO.nome", target = "nome"),
        @Mapping(source = "clienteDTO.cpf", target = "cpf"),
        @Mapping(source = "clienteDTO.telefone", target = "telefone"),
        @Mapping(source = "clienteDTO.whatsapp", target = "whatsapp"),
        @Mapping(source = "clienteDTO.email", target = "email"),
        @Mapping(source = "clienteDTO.endereco", target = "endereco"),
        @Mapping(source = "clienteDTO.dataNascimento", target = "dataNascimento")
    })
    @SuppressWarnings("UnmappedTargetProperties")
    Cliente toDomain(ClienteDTO clienteDTO);

    @Mappings({
        @Mapping(source = "cliente.id", target = "id"),
        @Mapping(source = "cliente.nome", target = "nome"),
        @Mapping(source = "cliente.cpf", target = "cpf"),
        @Mapping(source = "cliente.telefone", target = "telefone"),
        @Mapping(source = "cliente.whatsapp", target = "whatsapp"),
        @Mapping(source = "cliente.email", target = "email"),
        @Mapping(source = "cliente.endereco", target = "endereco"),
        @Mapping(source = "cliente.dataNascimento", target = "dataNascimento")
    })
    @SuppressWarnings("UnmappedTargetProperties")
    ClienteDTO toDto(Cliente cliente);

    default Cliente fromJpaToDomain(JpaCliente jpaCliente) {
        if (jpaCliente == null) {
            return null;
        }

        Cpf cpf = new Cpf(jpaCliente.getCpf().getCpf());
        
        Telefone telefone = new Telefone(jpaCliente.getTelefone().getNumero(), jpaCliente.getTelefone().getTipo());
        
        Telefone whatsapp = new Telefone(jpaCliente.getTelefone().getNumero(), jpaCliente.getTelefone().getTipo());
        
        Email email = new Email(jpaCliente.getEmail().getEmail());
        
        Endereco endereco = new Endereco(
            jpaCliente.getEndereco().getRua(),
            jpaCliente.getEndereco().getNumero(),
            jpaCliente.getEndereco().getComplemento(),
            jpaCliente.getEndereco().getBairro(),
            jpaCliente.getEndereco().getCidade(),
            jpaCliente.getEndereco().getEstado(),
            jpaCliente.getEndereco().getCep()
        );

        return new Cliente(
            jpaCliente.getId(),
            jpaCliente.getNome(),
            cpf,
            telefone,
            whatsapp,
            email,
            endereco,
            jpaCliente.getDataNascimento()
        );
    }

    default ClienteDTO fromJpaToDto(JpaCliente jpaCliente) {
        if (jpaCliente == null) {
            return null;
        }

        Cpf cpf = new Cpf(jpaCliente.getCpf().getCpf());
        
        Telefone telefone = new Telefone(jpaCliente.getTelefone().getNumero(), jpaCliente.getTelefone().getTipo());
        
        Telefone whatsapp = new Telefone(jpaCliente.getTelefone().getNumero(), jpaCliente.getTelefone().getTipo());
        
        Email email = new Email(jpaCliente.getEmail().getEmail());
        
        Endereco endereco = new Endereco(
            jpaCliente.getEndereco().getRua(),
            jpaCliente.getEndereco().getNumero(),
            jpaCliente.getEndereco().getComplemento(),
            jpaCliente.getEndereco().getBairro(),
            jpaCliente.getEndereco().getCidade(),
            jpaCliente.getEndereco().getEstado(),
            jpaCliente.getEndereco().getCep()
        );

        return new ClienteDTO(
            jpaCliente.getId(),
            jpaCliente.getNome(),
            cpf,
            telefone,
            whatsapp,
            email,
            endereco,
            jpaCliente.getDataNascimento()
        );
    }

}
