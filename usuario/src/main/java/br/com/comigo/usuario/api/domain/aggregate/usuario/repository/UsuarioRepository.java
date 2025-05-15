package br.com.comigo.usuario.api.domain.aggregate.usuario.repository;

import java.util.List;
import java.util.Optional;

import br.com.comigo.common.model.utils.Telefone;
import br.com.comigo.usuario.api.domain.aggregate.usuario.Usuario;
import br.com.comigo.usuario.api.domain.projection.UsuarioAndPapelProjection;

public interface UsuarioRepository {
    public Usuario create(Usuario usuario);

    public void update(Usuario usuario);

    public Optional<Usuario> findById(Long id);

    public Optional<Usuario> findByUsername(String username);

    public List<Usuario> findByNome(String nome);

    public List<Usuario> findByTelefone(Telefone telefone);

    public void deleteById(Long id);

    public List<UsuarioAndPapelProjection> findUsuarioVsPapel(String username);
}