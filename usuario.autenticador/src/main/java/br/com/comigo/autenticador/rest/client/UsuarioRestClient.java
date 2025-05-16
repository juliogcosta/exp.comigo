package br.com.comigo.autenticador.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarioRestClient", url = "http://localhost:8020")
public interface UsuarioRestClient {
    @GetMapping("/unsec/api/id/username/{username}/to-login")
    ResponseEntity<String> getUsuario(@PathVariable String username);
}