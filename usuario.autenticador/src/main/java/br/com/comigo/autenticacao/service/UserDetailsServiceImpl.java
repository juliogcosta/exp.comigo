package br.com.comigo.autenticacao.service;

import java.util.List;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.comigo.autenticacao.domain.Role;
import br.com.comigo.autenticacao.domain.User;
import br.com.comigo.autenticacao.exception.InconsistentUserRegisterException;
import br.com.comigo.autenticacao.rest.client.UsuarioRestClient;
import br.com.comigo.common.model.utils.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsuarioRestClient usuarioRestClient;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            ResponseEntity<String> responseEntity = usuarioRestClient.getUsuario(username);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                String raw = responseEntity.getBody();
                JSONObject jsUsuario = new JSONObject(raw);
                User.Status status = User.Status.ACTIVE;
                if (jsUsuario.has("status")) {
                    status = jsUsuario.getString("status").equals("ATIVO") ? User.Status.ACTIVE : User.Status.INACTIVE;
                } else {
                    status = User.Status.INACTIVE;
                }
                Email email = null;
                if (jsUsuario.has("email")) {
                    email = new Email(jsUsuario.getString("email"));
                } else {
                    throw new InconsistentUserRegisterException("Email not registered for user: " + username);
                }
                List<Role> roles = new ObjectMapper().readValue(jsUsuario.getString("roles"), new TypeReference<List<Role>>() {});
                return new User(
                    jsUsuario.getString("username"), 
                    jsUsuario.getString("password"),
                    jsUsuario.getString("name"), 
                    email,
                    status,
                    roles);
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage(), e.getCause());
        }
    }
}