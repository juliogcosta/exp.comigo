package br.com.comigo.autenticacao.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import br.com.comigo.autenticacao.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.comigo.autenticacao.dto.AuthrorizationResponse;
import br.com.comigo.autenticacao.dto.Credential;
import br.com.comigo.autenticacao.security.JwtUtils;

public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(path = "/sign-in", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestBody Credential credential)
    {
        try
        {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credential.getUsername().concat(":*"), credential.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = (User) authentication.getPrincipal();
            user.setStatus(user.getStatus());
            String jwt = jwtUtils.generateAccessToken(user);

            List<String> roles = user.getAuthorities().stream().map(item -> {
                return item.getAuthority();
            }).collect(Collectors.toList());

            AuthrorizationResponse jwtResponse = new AuthrorizationResponse(jwt, user.getUsername(), user.getName(), user.getEmail().valor(), roles);

            return ResponseEntity.ok(jwtResponse);
        }
        catch (BadCredentialsException e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}