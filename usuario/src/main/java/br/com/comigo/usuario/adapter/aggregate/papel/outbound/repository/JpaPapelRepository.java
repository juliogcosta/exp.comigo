package br.com.comigo.usuario.adapter.aggregate.papel.outbound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.usuario.adapter.aggregate.papel.outbound.JpaPapel;

public interface JpaPapelRepository extends JpaRepository<JpaPapel, Long> {
    public Optional<JpaPapel> findByNome(String nome);
}