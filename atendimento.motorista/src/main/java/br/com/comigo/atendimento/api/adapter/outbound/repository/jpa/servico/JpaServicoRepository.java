package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.servico;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.servico.JpaServico;
import br.com.comigo.atendimento.api.domain.projection.ServicoItemDeServicoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaServicoRepository extends JpaRepository<JpaServico, Long> {

    @Query("SELECT "
            + "s.id AS servicoId, "
            + "s.nome AS servicoNome, "
            + "s.descricao AS servicoDescricao, "
            + "s.status AS servicoStatus, "
            + "i.id AS itemDeServicoId, "
            + "i.nome AS itemDeServicoNome, "
            + "i.descricao AS itemDeServicoDescricao, "
            + "i.unidadeMedida AS itemDeServicoUnidadeMedida "
        + "FROM JpaServico s "
        + "LEFT JOIN JpaItemDeServico i ON s.id = i.servico.id "
        + "WHERE s.id = :servicoId")
    public Page<ServicoItemDeServicoProjection> findItemDeServicoByServicoId(@Param("servicoId") String servicoId, Pageable pageable);
}