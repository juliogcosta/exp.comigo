package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaPrestador;

public interface JpaPrestadorRepository extends JpaRepository<JpaPrestador, Long> {

    /*@Query("SELECT "
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
    public Page<PrestadorSetupDeItemDeServicoProjection> findSetupDeItemDeServicoByPrestadorCnpj(@Param("cnpj") String cnpj);*/

    public void update(JpaPrestador jpaPrestador);

    public Optional<JpaPrestador> findByCnpj_Cnpj(String cnpj);

    public List<JpaPrestador> findByNome(String nome);

    public List<JpaPrestador> findByTelefone_Numero(String numero);
}