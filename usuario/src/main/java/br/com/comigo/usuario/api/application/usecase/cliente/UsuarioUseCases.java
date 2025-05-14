package br.com.comigo.usuario.api.application.usecase.cliente;

import java.util.List;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.UsuarioDTO;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.PapelDeUsuarioDTO;
import br.com.comigo.usuario.api.domain.util.Telefone;

public interface UsuarioUseCases {
    public UsuarioDTO create(UsuarioDTO dto);

    public void update(UsuarioDTO dto);

    public UsuarioDTO getUsuarioDetailsById(Long id);

    public UsuarioDTO getUsuarioDetailsByUsername(String username);
    
    public List<UsuarioDTO> getFilteredUsuariosByNome(String nome);
    
    public List<UsuarioDTO> getFilteredUsuariosByTelefone(Telefone telefone);

    public void deleteUsuario(Long id);

    public void addPapelDeUsuarioToUsuario(PapelDeUsuarioDTO veiculoDTO, Long clienteId);

    public void deletePapelDeUsuario(Long id);
}
