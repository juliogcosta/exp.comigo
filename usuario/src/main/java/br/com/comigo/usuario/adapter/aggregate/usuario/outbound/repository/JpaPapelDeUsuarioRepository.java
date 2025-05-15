package br.com.comigo.usuario.adapter.aggregate.usuario.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.usuario.adapter.aggregate.usuario.outbound.JpaPapelDeUsuario;

public interface JpaPapelDeUsuarioRepository extends JpaRepository<JpaPapelDeUsuario, Long> {
  
}