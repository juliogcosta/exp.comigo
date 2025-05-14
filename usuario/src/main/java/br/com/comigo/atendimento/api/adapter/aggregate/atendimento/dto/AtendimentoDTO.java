package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.dto;

import java.util.List;

import br.com.comigo.atendimento.api.domain.util.Endereco;
import br.com.comigo.atendimento.api.domain.util.StatusDeAtendimento;

public record AtendimentoDTO(
        Long id,
        PrestadorDTO prestador,
        ClienteDTO cliente,
        VeiculoDTO veiculo,   
        String tipoOcorrencia,
        String tipoServico,
        StatusDeAtendimento status,
        Long dataHoraChamado,
        Long dataHoraConfirmado,
        Long dataHoraEmAndamento,
        Long dataHoraFinalizado,
        Long dataHoraCancelado,
        String descricao,
        Endereco base,
        Endereco origem,
        Endereco destino,
        List<ItemDeServicoDoAtendimentoDTO> itemDeServicoDoAtendimentos) {
    public record PrestadorDTO(
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
            String placa) {
    }
}