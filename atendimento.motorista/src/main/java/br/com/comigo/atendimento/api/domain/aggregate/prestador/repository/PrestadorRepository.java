package br.com.comigo.atendimento.api.domain.aggregate.prestador.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.prestador.Prestador;
import br.com.comigo.common.model.utils.Cnpj;
import br.com.comigo.common.model.utils.Telefone;

public interface PrestadorRepository {
    public Prestador create(Prestador prestador);

    public void update(Prestador prestador);

    public Optional<Prestador> findById(Long id);

    public Optional<Prestador> findByCnpj(Cnpj cnpj);

    public List<Prestador> findByNome(String nome);

    public List<Prestador> findByTelefone(Telefone telefone);

    public void deleteById(Long id);
}