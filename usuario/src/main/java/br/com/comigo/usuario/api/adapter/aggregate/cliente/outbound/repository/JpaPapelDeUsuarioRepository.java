package br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaPapelDeUsuario;

public interface JpaPapelDeUsuarioRepository extends JpaRepository<JpaPapelDeUsuario, Long> {
  
}