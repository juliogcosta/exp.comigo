package br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.servico.outbound.JpaServico;

public interface JpaServicoRepository extends JpaRepository<JpaServico, Long> {

    /*@Query("SELECT "
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
    public Page<ServicoItemDeServicoProjection> findItemDeServicoByServicoId(@Param("servicoId") String servicoId, Pageable pageable);*/

    public void update(JpaServico jpaServico);

    public Optional<JpaServico> findByNome(String nome);
}