package br.com.comigo.gateway.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SecurityRules {
    private final Map<String, List<String>> pathRoles;
    
    public SecurityRules() {
        pathRoles = new HashMap<>();
        pathRoles.put("/v1/id/", List.of("ADMIN", "GERENTE"));
        pathRoles.put("/v1/atendimento/", List.of("ADMIN", "GERENTE", "ATENDENTE"));
    }
    
    public boolean isAuthorized(String path, List<String> userRoles) {
        return pathRoles.entrySet().stream()
            .filter(entry -> path.startsWith(entry.getKey()))
            .findFirst()
            .map(entry -> entry.getValue().stream()
                .anyMatch(userRoles::contains))
            .orElse(false);
    }
}