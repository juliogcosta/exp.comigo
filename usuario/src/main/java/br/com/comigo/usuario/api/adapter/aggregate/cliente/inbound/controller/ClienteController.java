package br.com.comigo.usuario.api.adapter.aggregate.cliente.inbound.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.UsuarioDTO;
import br.com.comigo.usuario.api.adapter.aggregate.cliente.dto.PapelDeUsuarioDTO;
import br.com.comigo.usuario.api.application.aggregate.service.cliente.UsuarioServiceImpl;
import br.com.comigo.usuario.api.domain.util.Telefone;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuario/usuario")
public class ClienteController {
    private final UsuarioServiceImpl usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO newUsuario = this.usuarioService.create(usuarioDTO);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> update(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        this.usuarioService.update(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioDetailsById(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = this.usuarioService.getUsuarioDetailsById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioDTO> getUsuarioDetailsByUsername(String username) {
        UsuarioDTO usernameDTO = this.usuarioService.getUsuarioDetailsByUsername(username);
        return ResponseEntity.ok(usernameDTO);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<UsuarioDTO>> getUsuariosByNome(@PathVariable String nome) {
        List<UsuarioDTO> usuarioDTOs = this.usuarioService.getFilteredUsuariosByNome(nome);
        return ResponseEntity.ok(usuarioDTOs);
    }

    @GetMapping("/telefoneNumero/{telefoneNumero}")
    public ResponseEntity<List<UsuarioDTO>> getUsuariosByTelefone(@PathVariable String telefoneNumero) {
        Telefone telefone = new Telefone(telefoneNumero, null);
        List<UsuarioDTO> usuarioDTOs = this.usuarioService.getFilteredUsuariosByTelefone(telefone);
        return ResponseEntity.ok(usuarioDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/veiculo")
    public ResponseEntity<Void> addPapelDeUsuarioToUsuario(@PathVariable Long id, @RequestBody PapelDeUsuarioDTO papelDeUsuarioDTO) {
        this.usuarioService.addPapelDeUsuarioToUsuario(papelDeUsuarioDTO, id);
        return ResponseEntity.ok().build();
    }
}
