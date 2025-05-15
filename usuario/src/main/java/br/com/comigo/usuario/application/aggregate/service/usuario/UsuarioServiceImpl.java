package br.com.comigo.usuario.application.aggregate.service.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.comigo.common.model.utils.Telefone;
import br.com.comigo.usuario.adapter.aggregate.usuario.dto.PapelDeUsuarioDTO;
import br.com.comigo.usuario.adapter.aggregate.usuario.dto.UsuarioDTO;
import br.com.comigo.usuario.adapter.aggregate.usuario.dto.UsuarioForLoginDTO;
import br.com.comigo.usuario.application.usecase.usuario.UsuarioUseCases;
import br.com.comigo.usuario.domain.aggregate.usuario.PapelDeUsuario;
import br.com.comigo.usuario.domain.aggregate.usuario.Usuario;
import br.com.comigo.usuario.domain.aggregate.usuario.repository.PapelDeUsuarioRepository;
import br.com.comigo.usuario.domain.aggregate.usuario.repository.UsuarioRepository;
import br.com.comigo.usuario.domain.projection.UsuarioAndPapelProjection;
import br.com.comigo.usuario.mapper.aggregate.usuario.PapelDeUsuarioMapper;
import br.com.comigo.usuario.mapper.aggregate.usuario.UsuarioMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioUseCases {

    private final UsuarioRepository usuarioRepository;
    private final PapelDeUsuarioRepository papelDeUsuarioRepository;
    private final UsuarioMapper clienteMapper;
    private final PapelDeUsuarioMapper papelDeUsuarioMapper;

    @Override
    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario cliente = this.usuarioRepository.create(this.clienteMapper.toDomain(dto));
        return this.clienteMapper.toDto(cliente);
    }

    @Override
    public void update(UsuarioDTO dto) {
        this.usuarioRepository.update(this.clienteMapper.toDomain(dto));
    }

    @Override
    public UsuarioDTO getUsuarioDetailsById(Long id) {
        Usuario cliente = this.usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente not found"));
        return this.clienteMapper.toDto(cliente);
    }

    @Override
    public UsuarioDTO getUsuarioDetailsByUsername(String username) {
        Usuario usuario = this.usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
        return this.clienteMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioDTO> getFilteredUsuariosByNome(String nome) {
        return this.usuarioRepository.findByNome(nome).stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    @Override
    public List<UsuarioDTO> getFilteredUsuariosByTelefone(Telefone telefone) {
        return this.usuarioRepository.findByTelefone(telefone).stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    @Override
    public void deleteUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void addPapelDeUsuarioToUsuario(PapelDeUsuarioDTO papelDeUsuarioDTO, Long usuarioId) {
        PapelDeUsuario papelDeUsuario = this.papelDeUsuarioMapper.toDomain(papelDeUsuarioDTO);
        this.papelDeUsuarioRepository.create(papelDeUsuario, usuarioId);
    }

    @Override
    public void deletePapelDeUsuario(Long id) {
        this.papelDeUsuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioForLoginDTO getUsuarioForLogin(String username) {
        List<UsuarioAndPapelProjection> usuarioAndPapelProjections = this.usuarioRepository.findUsuarioVsPapel(username);
        if (usuarioAndPapelProjections == null || usuarioAndPapelProjections.size() > 0) {
            return new UsuarioForLoginDTO(null, null, null, null, null, null, null);
        } else {
            List<UsuarioForLoginDTO.PapelForLoginDTO> papelForLoginDTOs = usuarioAndPapelProjections.stream().map(usuarioAndPapelProjection -> {
                return new UsuarioForLoginDTO.PapelForLoginDTO(usuarioAndPapelProjection.getPapelNome(), usuarioAndPapelProjection.getPapelStatus());
            }).collect(Collectors.toList());
            UsuarioAndPapelProjection usuarioAndPapelProjection = usuarioAndPapelProjections.get(0);
            return new UsuarioForLoginDTO(
                usuarioAndPapelProjection.getNome(), 
                usuarioAndPapelProjection.getUsername(), 
                usuarioAndPapelProjection.getPassword(), 
                usuarioAndPapelProjection.getEmail(), 
                usuarioAndPapelProjection.getTelefone(), 
                usuarioAndPapelProjection.getStatus(), 
                papelForLoginDTOs);
        }
    }
}