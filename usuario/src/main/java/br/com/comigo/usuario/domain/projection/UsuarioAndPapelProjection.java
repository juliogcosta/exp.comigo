package br.com.comigo.usuario.domain.projection;

import br.com.comigo.usuario.adapter.util.JpaTelefone;

public interface UsuarioAndPapelProjection {
    Long getId();
    String getUsername();
    String getPassword();
    String getNome();
    JpaTelefone getTelefone();
    String getEmail();
    String getStatus();
    String getPapelNome();
    String getPapelStatus();
}