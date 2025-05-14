package br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.outbound.JpaUsuario;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuario, Long> {
    public Optional<JpaUsuario> findByUsername(String username);

    public List<JpaUsuario> findByNome(String nome);

    public List<JpaUsuario> findByTelefone_Numero(String numero);
}