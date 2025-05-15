package br.com.comigo.usuario.adapter.aggregate.usuario.dto;

import java.util.List;

import br.com.comigo.common.model.utils.Email;
import br.com.comigo.common.model.utils.Telefone;
import br.com.comigo.usuario.domain.util.StatusDeUsuario;

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