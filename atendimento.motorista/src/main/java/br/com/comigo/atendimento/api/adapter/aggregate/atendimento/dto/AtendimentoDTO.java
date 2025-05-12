package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto;

import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;

public record AtendimentoDTO(
        Long id,
        PrestadorDTO prestadorDTO,
        ClienteDTO clienteDTO,
        VeiculoDTO veiculoDTO,
        String tipoOcorrencia,
        String tipoServico,
        StatusDeAtendimento status,
        Long dataHoraChamado,
        Long dataHoraAutorizado,
        Long dataHoraEmAndamento,
        Long dataHoraFinalizado,
        Long dataHoraCancelado,
        String descricao,
        Endereco base,
        Endereco origem,
        Endereco destino) {
    public record PrestadorDTO(
            Long id) {
    }

    public record SetupDeItemDoServicoDTO(
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