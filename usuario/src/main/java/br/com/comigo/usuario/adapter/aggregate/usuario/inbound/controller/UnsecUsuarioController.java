package br.com.comigo.usuario.adapter.aggregate.usuario.inbound.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.comigo.usuario.adapter.aggregate.usuario.dto.UsuarioForLoginDTO;
import br.com.comigo.usuario.application.aggregate.service.usuario.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController("/unsec/api/id")
public class UnsecUsuarioController {
    private final UsuarioServiceImpl usuarioService;
    
    @GetMapping("/unsec/api/id/username/{username}/to-login")
    public ResponseEntity<UsuarioForLoginDTO> getUsuario(@PathVariable String username) {
        UsuarioForLoginDTO usuarioForLoginDTO = this.usuarioService.getUsuarioForLogin(username);
        return ResponseEntity.ok().body(usuarioForLoginDTO);
    }
}