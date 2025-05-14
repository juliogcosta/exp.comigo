package br.com.comigo.usuario.api.domain.aggregate.cliente.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.usuario.api.domain.aggregate.cliente.PapelDeUsuario;

public interface PapelDeUsuarioRepository {
    public void create(PapelDeUsuario papelDeUsuario, Long usuarioId);

    public Optional<PapelDeUsuario> findById(Long id);

    public List<PapelDeUsuario> findAll();

    public void deleteById(Long id);
}