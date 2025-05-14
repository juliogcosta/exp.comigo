package br.com.comigo.atendimento.api.mapper.aggregate.atendimento;

import java.sql.Timestamp;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.slf4j.LoggerFactory;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.ItemDeServicoDoAtendimentoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO.ClienteDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO.PrestadorDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto.AtendimentoDTO.VeiculoDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.JpaAtendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.Atendimento;
import br.com.comigo.atendimento.api.domain.aggregate.atendimento.ItemDeServicoDoAtendimento;
import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.Telefone;

@Mapper(componentModel = "spring")
public interface AtendimentoMapper {

    @Mapping(source = "atendimentoDTO.id", target = "id")
    @Mapping(source = "atendimentoDTO.cliente.nome", target = "clienteNome")
    @Mapping(source = "atendimentoDTO.cliente.telefone", target = "clienteTelefone.numero")
    @Mapping(target = "clienteTelefone.tipo", ignore = true)
    @Mapping(source = "atendimentoDTO.cliente.whatsapp", target = "clienteWhatsapp.numero")
    @Mapping(target = "clienteWhatsapp.tipo", ignore = true)
    @Mapping(source = "atendimentoDTO.cliente.id", target = "clienteId")
    @Mapping(source = "atendimentoDTO.veiculo.id", target = "veiculoId")
    @Mapping(source = "atendimentoDTO.veiculo.placa", target = "veiculoPlaca")
    @Mapping(source = "atendimentoDTO.prestador.id", target = "prestadorId")
    @Mapping(source = "atendimentoDTO.tipoOcorrencia", target = "tipoOcorrencia")
    @Mapping(source = "atendimentoDTO.tipoServico", target = "tipoServico")
    @Mapping(source = "atendimentoDTO.dataHoraChamado", target = "dataHoraChamado", qualifiedByName = "epochToTimestamp")
    @Mapping(source = "atendimentoDTO.dataHoraConfirmado", target = "dataHoraConfirmado", qualifiedByName = "epochToTimestamp")
    @Mapping(source = "atendimentoDTO.dataHoraEmAndamento", target = "dataHoraEmAndamento", qualifiedByName = "epochToTimestamp")
    @Mapping(source = "atendimentoDTO.dataHoraFinalizado", target = "dataHoraFinalizado", qualifiedByName = "epochToTimestamp")
    @Mapping(source = "atendimentoDTO.dataHoraCancelado", target = "dataHoraCancelado", qualifiedByName = "epochToTimestamp")
    @Mapping(source = "atendimentoDTO.origem", target = "origem")
    @Mapping(source = "atendimentoDTO.destino", target = "destino")
    @Mapping(source = "atendimentoDTO.base", target = "base")
    @Mapping(target = "itemDeServicoDoAtendimentos", ignore = true)
    Atendimento toDomain(AtendimentoDTO atendimentoDTO);

    @Mapping(source = "atendimento.id", target = "id")
    @Mapping(source = "atendimento.clienteNome", target = "cliente.nome")
    @Mapping(source = "atendimento.clienteTelefone", target = "cliente.telefone", qualifiedByName = "telefoneToString")
    @Mapping(source = "atendimento.clienteWhatsapp", target = "cliente.whatsapp", qualifiedByName = "telefoneToString")
    @Mapping(source = "atendimento.clienteId", target = "cliente.id")
    @Mapping(source = "atendimento.veiculoId", target = "veiculo.id")
    @Mapping(source = "atendimento.veiculoPlaca", target = "veiculo.placa")
    @Mapping(source = "atendimento.prestadorId", target = "prestador.id")
    @Mapping(source = "atendimento.tipoOcorrencia", target = "tipoOcorrencia")
    @Mapping(source = "atendimento.tipoServico", target = "tipoServico")
    @Mapping(source = "atendimento.dataHoraChamado", target = "dataHoraChamado", qualifiedByName = "timestampToEpoch")
    @Mapping(source = "atendimento.dataHoraConfirmado", target = "dataHoraConfirmado", qualifiedByName = "timestampToEpoch")
    @Mapping(source = "atendimento.dataHoraEmAndamento", target = "dataHoraEmAndamento", qualifiedByName = "timestampToEpoch")
    @Mapping(source = "atendimento.dataHoraFinalizado", target = "dataHoraFinalizado", qualifiedByName = "timestampToEpoch")
    @Mapping(source = "atendimento.dataHoraCancelado", target = "dataHoraCancelado", qualifiedByName = "timestampToEpoch")
    @Mapping(source = "atendimento.origem", target = "origem")
    @Mapping(source = "atendimento.base", target = "base")
    AtendimentoDTO toDto(Atendimento atendimento);

    @Named("epochToTimestamp")
    default Timestamp epochToTimestamp(Long timestamp) {
        return timestamp != null ? new Timestamp(timestamp) : null;
    }

    @Named("timestampToEpoch")
    default Long timestampToEpoch(Timestamp date) {
        return date != null ? date.getTime() : null;
    }

    @Named("telefoneToString")
    default String telefoneToString(Telefone telefone) {
        return telefone != null ? telefone.numero() : null;
    }

    default Atendimento fromJpaToDomain(JpaAtendimento jpaAtendimento) {
        if (jpaAtendimento == null) {
            return null;
        }

        List<ItemDeServicoDoAtendimento> itemDeServicoDoAtendimentos = null;
        if (jpaAtendimento.getItemDeServicoDoAtendimentos() == null) {

        } else itemDeServicoDoAtendimentos = jpaAtendimento.getItemDeServicoDoAtendimentos().stream()
                .map(item -> {
                    ItemDeServicoDoAtendimento itemDeServicoDoAtendimento = new ItemDeServicoDoAtendimento(
                        item.getId(), 
                        item.getSetupDeItemDoServicoId(),  
                        item.getQuantidade());
                    itemDeServicoDoAtendimento.setObservacao(item.getObservacao() == null ? "" : item.getObservacao());
                    return itemDeServicoDoAtendimento;
                })
                .toList();
        LoggerFactory.getLogger(getClass()).info("> itemDeServicoDoAtendimentos: {}", itemDeServicoDoAtendimentos);

        Atendimento atendimento = new Atendimento(
            jpaAtendimento.getId(),
            jpaAtendimento.getClienteNome(),
            new Telefone(jpaAtendimento.getClienteTelefone().getNumero(), jpaAtendimento.getClienteTelefone().getTipo()),
            new Telefone(jpaAtendimento.getClienteWhatsapp().getNumero(), jpaAtendimento.getClienteWhatsapp().getTipo()),
            jpaAtendimento.getVeiculoId(),
            jpaAtendimento.getVeiculoPlaca(),
            jpaAtendimento.getTipoOcorrencia(),
            jpaAtendimento.getTipoServico(),
            new Endereco(jpaAtendimento.getOrigem().getLogradouro(), 
                jpaAtendimento.getOrigem().getNumero(), 
                jpaAtendimento.getOrigem().getComplemento(), 
                jpaAtendimento.getOrigem().getBairro(), 
                jpaAtendimento.getOrigem().getCidade(), 
                jpaAtendimento.getOrigem().getEstado(), 
                jpaAtendimento.getOrigem().getCep()),
            new Endereco(jpaAtendimento.getDestino().getLogradouro(), 
                jpaAtendimento.getDestino().getNumero(), 
                jpaAtendimento.getDestino().getComplemento(), 
                jpaAtendimento.getDestino().getBairro(), 
                jpaAtendimento.getDestino().getCidade(), 
                jpaAtendimento.getDestino().getEstado(), 
                jpaAtendimento.getDestino().getCep()),
            new Endereco(jpaAtendimento.getBase().getLogradouro(), 
                jpaAtendimento.getBase().getNumero(), 
                jpaAtendimento.getBase().getComplemento(), 
                jpaAtendimento.getBase().getBairro(), 
                jpaAtendimento.getBase().getCidade(), 
                jpaAtendimento.getBase().getEstado(), 
                jpaAtendimento.getBase().getCep())
        );
        atendimento.setItemDeServicoDoAtendimentos(itemDeServicoDoAtendimentos);

        return atendimento;
    }

    default AtendimentoDTO fromJpaToDto(JpaAtendimento jpaAtendimento) {
        if (jpaAtendimento == null) {
            return null;
        }

        List<ItemDeServicoDoAtendimentoDTO> itemDeServicoDoAtendimentos = null;
        if (jpaAtendimento.getItemDeServicoDoAtendimentos() == null) {

        } else itemDeServicoDoAtendimentos = jpaAtendimento.getItemDeServicoDoAtendimentos().stream()
        .map(item -> {
            ItemDeServicoDoAtendimentoDTO itemDeServicoDoAtendimento = new ItemDeServicoDoAtendimentoDTO(
                item.getId(), 
                item.getSetupDeItemDoServicoId(),  
                item.getQuantidade(),
                item.getObservacao() == null ? "" : item.getObservacao());
            return itemDeServicoDoAtendimento;
        })
        .toList();

        return new AtendimentoDTO(
            jpaAtendimento.getId(),
            new PrestadorDTO(jpaAtendimento.getPrestadorId()),
            new ClienteDTO(jpaAtendimento.getClienteId(), 
                jpaAtendimento.getClienteNome(), 
                jpaAtendimento.getClienteTelefone().getNumero(), 
                jpaAtendimento.getClienteWhatsapp().getNumero()),
            new VeiculoDTO(jpaAtendimento.getVeiculoId(),
                jpaAtendimento.getVeiculoPlaca()),
            jpaAtendimento.getTipoOcorrencia(),
            jpaAtendimento.getTipoServico(),
            jpaAtendimento.getStatus(),
            jpaAtendimento.getDataHoraChamado() != null ? jpaAtendimento.getDataHoraChamado().getTime() : null,
            jpaAtendimento.getDataHoraConfirmado() != null ? jpaAtendimento.getDataHoraConfirmado().getTime() : null,
            jpaAtendimento.getDataHoraEmAndamento() != null ? jpaAtendimento.getDataHoraEmAndamento().getTime() : null,
            jpaAtendimento.getDataHoraFinalizado() != null ? jpaAtendimento.getDataHoraFinalizado().getTime() : null,
            jpaAtendimento.getDataHoraCancelado() != null ? jpaAtendimento.getDataHoraCancelado().getTime() : null, 
            jpaAtendimento.getDescricao(),
            new Endereco(jpaAtendimento.getBase().getLogradouro(), 
                jpaAtendimento.getBase().getNumero(), 
                jpaAtendimento.getBase().getComplemento(), 
                jpaAtendimento.getBase().getBairro(), 
                jpaAtendimento.getBase().getCidade(), 
                jpaAtendimento.getBase().getEstado(), 
                jpaAtendimento.getBase().getCep()),
            new Endereco(jpaAtendimento.getOrigem().getLogradouro(), 
                jpaAtendimento.getOrigem().getNumero(), 
                jpaAtendimento.getOrigem().getComplemento(), 
                jpaAtendimento.getOrigem().getBairro(), 
                jpaAtendimento.getOrigem().getCidade(), 
                jpaAtendimento.getOrigem().getEstado(), 
                jpaAtendimento.getOrigem().getCep()),
            new Endereco(jpaAtendimento.getDestino().getLogradouro(), 
                jpaAtendimento.getDestino().getNumero(), 
                jpaAtendimento.getDestino().getComplemento(), 
                jpaAtendimento.getDestino().getBairro(), 
                jpaAtendimento.getDestino().getCidade(), 
                jpaAtendimento.getDestino().getEstado(), 
                jpaAtendimento.getDestino().getCep()),
            itemDeServicoDoAtendimentos
        );
    }
}