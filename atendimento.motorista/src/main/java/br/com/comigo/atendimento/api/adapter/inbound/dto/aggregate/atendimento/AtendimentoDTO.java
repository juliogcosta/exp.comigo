package br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.atendimento;

import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;

public record AtendimentoDTO(
    Long id,
    PrestadorDTO prestadorDTO,
    SetupDeItemDeServicoDTO setupDeItemDeServicoDTO,
    ClienteDTO clienteDTO,
    VeiculoDTO veiculoDTO,
    String tipoOcorrencia,
    StatusDeAtendimento status,
    Long dataHoraChamado,
    Long dataHoraAutorizado,
    Long dataHoraEmAndamento,
    Long dataHoraFinalizado,
    Long dataHoraCancelado,
    String descricao,
    Endereco base,
    Endereco origem,
    Endereco destino
) {
    public record PrestadorDTO(
        Long id) {
    }
    public record SetupDeItemDeServicoDTO(
        Long id) {
    }
    public record ClienteDTO(
        Long id,
        String nome,
        String telefone,
        String whatsapp) {
    }
    public record VeiculoDTO(
        Long id,
        String veiculoPlaca) {
    }
}