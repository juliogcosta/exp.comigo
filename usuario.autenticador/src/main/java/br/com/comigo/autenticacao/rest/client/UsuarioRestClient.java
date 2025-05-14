package br.com.comigo.autenticacao.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarioRestClient", url = "http://localhost:8020")
public interface UsuarioRestClient {
    @GetMapping("/api/usuario/for-login/usuario/username/{username}")
    ResponseEntity<String> getUsuario(@PathVariable String username);
}