package br.com.comigo.autenticacao.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.comigo.common.model.utils.Email;

public class User implements UserDetails {
    public enum Status {
        ACTIVE,
        INACTIVE,
    }

    String username;
    String password;
    String name;
    Email email;
    Status status;
    List<Role> roles;

    public User(String username, String password, String name, Email email, Status status, List<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
        this.roles = roles;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.roles.stream().filter(role -> role.getStatus().name().equals(Role.Status.ACTIVE.name())).map(role -> {
                if (role.getName().startsWith("ROLE_")) {
                    return new SimpleGrantedAuthority(role.getName());
                } else {
                    return new SimpleGrantedAuthority("ROLE_".concat(role.getName()));
                }
            }).collect(Collectors.toList());
    }
}