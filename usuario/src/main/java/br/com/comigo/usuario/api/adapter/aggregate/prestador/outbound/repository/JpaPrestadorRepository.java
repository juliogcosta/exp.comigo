package br.com.comigo.usuario.api.adapter.aggregate.prestador.outbound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.usuario.api.adapter.aggregate.prestador.outbound.JpaPapel;

public interface JpaPrestadorRepository extends JpaRepository<JpaPapel, Long> {
    public Optional<JpaPapel> findByNome(String nome);
}