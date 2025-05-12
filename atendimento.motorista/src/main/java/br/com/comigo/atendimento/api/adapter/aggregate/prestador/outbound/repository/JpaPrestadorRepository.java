package br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.atendimento.api.adapter.aggregate.prestador.outbound.JpaPrestador;

public interface JpaPrestadorRepository extends JpaRepository<JpaPrestador, Long> {

    /*
     * @Query("SELECT "
     * + "p.id AS prestadorId, "
     * + "p.nome AS prestadorNome, "
     * + "p.cnpj.cnpj AS prestadorCnpj, "
     * + "p.telefone.numero AS prestadorTelefoneNumero, "
     * + "p.telefone.tipo AS prestadorTelefoneTipo, "
     * + "p.email.email AS prestadorEmail, "
     * + "p.endereco.rua AS prestadorEnderecoRua, "
     * + "p.endereco.numero AS prestadorEnderecoNumero, "
     * + "p.endereco.complemento AS prestadorEnderecoComplemento, "
     * + "p.endereco.bairro AS prestadorEnderecoBairro, "
     * + "p.endereco.cidade AS prestadorEnderecoCidade, "
     * + "p.endereco.estado AS prestadorEnderecoEstado, "
     * + "p.endereco.cep AS prestadorEnderecoCep, "
     * + "s.status AS setupDeItemDoServicoStatus, "
     * + "s.precoUnitario AS setupDeItemDoServicoPrecoUnitario, "
     * + "s.itemDeServicoId AS setupDeItemDoServicoItemDeServicoId "
     * + "FROM JpaPrestador p "
     * + "LEFT JOIN JpaSetupDeItemDoServico s ON p.id = s.prestador.id "
     * + "WHERE p.cnpj.cnpj = :cnpj")
     * public Page<PrestadorSetupDeItemDoServicoProjection>
     * findSetupDeItemDoServicoByPrestadorCnpj(@Param("cnpj") String cnpj);
     */

    public Optional<JpaPrestador> findByCnpj_Cnpj(String cnpj);

    public List<JpaPrestador> findByNome(String nome);

    public List<JpaPrestador> findByTelefone_Numero(String numero);
}