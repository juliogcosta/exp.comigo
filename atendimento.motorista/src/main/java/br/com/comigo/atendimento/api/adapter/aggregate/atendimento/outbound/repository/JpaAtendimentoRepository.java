package br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.repository;

import br.com.comigo.atendimento.api.adapter.aggregate.atendimento.outbound.JpaAtendimento;
import br.com.comigo.atendimento.api.domain.projection.AtendimentoItemDeServicoDoAtendimentoProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaAtendimentoRepository extends JpaRepository<JpaAtendimento, Long> {

    @Query("SELECT "
            + "a.id AS atendimentoId, "
            + "a.prestadorId AS prestadorId, "
            + "a.clienteId AS clienteId, "
            + "a.clienteNome AS clienteNome, "
            + "a.clienteTelefone.numero AS clienteTelefoneNumero, "
            + "a.clienteTelefone.tipo AS clienteTelefoneTipo, "
            + "a.veiculoId AS veiculoId, "
            + "a.veiculoPlaca AS veiculoPlaca, "
            + "a.tipoOcorrencia AS tipoOcorrencia, "
            + "a.tipoServico AS tipoServico, "
            + "a.status AS status, "
            + "a.dataHoraChamado AS dataHoraChamado, "
            + "a.dataHoraFinalizado AS dataHoraFinalizado, "
            + "a.origem AS origem, "
            + "a.destino AS destino, "
            + "i.itemDeServicoId AS itemDeServicoId, "
            + "i.quantidade AS quantidade, "
            + "i.valorUnitario AS valorUnitario "
        + "FROM JpaAtendimento a "
        + "LEFT JOIN JpaItemDeServicoDoAtendimento i ON a.id = i.atendimento.id "
        + "WHERE a.prestadorId = :prestadorId")
    public Page<AtendimentoItemDeServicoDoAtendimentoProjection> findAtendimentosComItensDeServicoByPrestadorId(
        @Param("prestadorId") Long prestadorId, Pageable pageable);

    @Query("SELECT "
            + "a.id AS atendimentoId, "
            + "a.prestadorId AS prestadorId, "
            + "a.clienteId AS clienteId, "
            + "a.clienteNome AS clienteNome, "
            + "a.clienteTelefone.numero AS clienteTelefoneNumero, "
            + "a.clienteTelefone.tipo AS clienteTelefoneTipo, "
            + "a.veiculoId AS veiculoId, "
            + "a.veiculoPlaca AS veiculoPlaca, "
            + "a.tipoOcorrencia AS tipoOcorrencia, "
            + "a.tipoServico AS tipoServico, "
            + "a.status AS status, "
            + "a.dataHoraChamado AS dataHoraChamado, "
            + "a.dataHoraFinalizado AS dataHoraFinalizado, "
            + "a.origem AS origem, "
            + "a.destino AS destino, "
            + "i.itemDeServicoId AS itemDeServicoId, "
            + "i.quantidade AS quantidade, "
            + "i.valorUnitario AS valorUnitario "
        + "FROM JpaAtendimento a "
        + "LEFT JOIN JpaItemDeServicoDoAtendimento i ON a.id = i.atendimento.id "
        + "WHERE a.veiculoPlaca = :veiculoPlaca")
    public Page<AtendimentoItemDeServicoDoAtendimentoProjection> findAtendimentosComItensDeServicoByVeiculoPlaca(
        @Param("veiculoPlaca") String veiculoPlaca, Pageable pageable);

    @Query("SELECT "
            + "a.id AS atendimentoId, "
            + "a.prestadorId AS prestadorId, "
            + "a.clienteId AS clienteId, "
            + "a.clienteNome AS clienteNome, "
            + "a.clienteTelefone.numero AS clienteTelefoneNumero, "
            + "a.clienteTelefone.tipo AS clienteTelefoneTipo, "
            + "a.veiculoId AS veiculoId, "
            + "a.veiculoPlaca AS veiculoPlaca, "
            + "a.tipoOcorrencia AS tipoOcorrencia, "
            + "a.tipoServico AS tipoServico, "
            + "a.status AS status, "
            + "a.dataHoraChamado AS dataHoraChamado, "
            + "a.dataHoraFinalizado AS dataHoraFinalizado, "
            + "a.origem AS origem, "
            + "a.destino AS destino, "
            + "i.itemDeServicoId AS itemDeServicoId, "
            + "i.quantidade AS quantidade, "
            + "i.valorUnitario AS valorUnitario "
        + "FROM JpaAtendimento a "
        + "LEFT JOIN JpaItemDeServicoDoAtendimento i ON a.id = i.atendimento.id "
        + "WHERE a.clienteTelefone.numero = :clienteTelefoneNumero")
    public Page<AtendimentoItemDeServicoDoAtendimentoProjection> findAtendimentosComItensDeServicoByClienteTelefoneNumero(
        @Param("clienteTelefoneNumero") String clienteTelefoneNumero, Pageable pageable);
}