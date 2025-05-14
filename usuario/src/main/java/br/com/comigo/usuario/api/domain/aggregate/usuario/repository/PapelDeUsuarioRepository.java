package br.com.comigo.usuario.api.domain.aggregate.usuario.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.usuario.api.domain.aggregate.usuario.PapelDeUsuario;

public interface PapelDeUsuarioRepository {
    public void create(PapelDeUsuario papelDeUsuario, Long usuarioId);

    public Optional<PapelDeUsuario> findById(Long id);

    public List<PapelDeUsuario> findAll();

    public void deleteById(Long id);
}