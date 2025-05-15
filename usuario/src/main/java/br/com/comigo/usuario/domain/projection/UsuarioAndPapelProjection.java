package br.com.comigo.usuario.domain.projection;

public interface UsuarioAndPapelProjection {
    Long getId();
    String getUsername();
    String getPassword();
    String getNome();
    String getTelefone();
    String getEmail();
    String getStatus();
    String getPapelNome();
    String getPapelStatus();
}