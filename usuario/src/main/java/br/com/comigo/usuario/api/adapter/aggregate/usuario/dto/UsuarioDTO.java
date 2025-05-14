package br.com.comigo.usuario.api.adapter.aggregate.usuario.dto;

import java.util.List;

import br.com.comigo.usuario.api.domain.util.Email;
import br.com.comigo.usuario.api.domain.util.StatusDeUsuario;
import br.com.comigo.usuario.api.domain.util.Telefone;

public record UsuarioDTO(
    Long id,
    String username,
    String password,
    String nome,
    Telefone telefone,
    Email email,
    StatusDeUsuario status,
    List<PapelDeUsuarioDTO> papelDeUsuarios
) {
}