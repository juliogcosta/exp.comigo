package br.com.comigo.atendimento.api.adapter.outbound.repository.jpa;

import br.com.comigo.atendimento.api.adapter.outbound.aggregate.prestador.JpaPrestador;
import br.com.comigo.atendimento.api.domain.projection.PrestadorSetupDeItemDeServicoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPrestadorRepository extends JpaRepository<JpaPrestador, Long> {

    @Query("SELECT "
        + "p.id AS prestadorId, "
        + "p.nome AS prestadorNome, "
        + "p.cnpj.cnpj AS prestadorCnpj, "
        + "p.telefone.numero AS prestadorTelefoneNumero, "
        + "p.telefone.tipo AS prestadorTelefoneTipo, "
        + "p.email.email AS prestadorEmail, "
        + "p.endereco.rua AS prestadorEnderecoRua, "
        + "p.endereco.numero AS prestadorEnderecoNumero, "
        + "p.endereco.complemento AS prestadorEnderecoComplemento, "
        + "p.endereco.bairro AS prestadorEnderecoBairro, "
        + "p.endereco.cidade AS prestadorEnderecoCidade, "
        + "p.endereco.estado AS prestadorEnderecoEstado, "
        + "p.endereco.cep AS prestadorEnderecoCep, "
        + "s.status AS setupDeItemDeServicoStatus, "
        + "s.precoUnitario AS setupDeItemDeServicoPrecoUnitario, "
        + "s.itemDeServicoId AS setupDeItemDeServicoItemDeServicoId "
        + "FROM JpaPrestador p "
        + "LEFT JOIN JpaSetupDeItemDeServico s ON p.id = s.prestador.id "
        + "WHERE p.cnpj.cnpj = :cnpj")
    Page<PrestadorSetupDeItemDeServicoProjection> findSetupDeItemDeServicoByPrestadorCnpj(@Param("cnpj") String cnpj);
}