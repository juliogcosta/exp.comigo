package br.com.comigo.gateway.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final SecurityRules securityRules;
    private final List<String> publicPaths;
    
    public JwtAuthenticationFilter(
            @Value("${yc.security.keys.accessToken.secret}") String secret,
            @Value("${yc.security.public-paths}") List<String> publicPaths,
            SecurityRules securityRules) {
        this.algorithm = Algorithm.HMAC512(secret);
        this.publicPaths = publicPaths;
        this.verifier = JWT.require(algorithm)
            .withIssuer("Comigo Auth-Service")
            .build();
        this.securityRules = securityRules;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        
        if (isPublicPath(path)) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        try {
            DecodedJWT jwt = verifier.verify(authHeader.substring(7));
            List<String> roles = extractRoles(jwt);
            
            if (!securityRules.isAuthorized(path, roles)) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
            
            return chain.filter(exchange);
        } catch (Exception e) {
            logger.error("JWT Authentication failed", e);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    private List<String> extractRoles(DecodedJWT jwt) {
        String roles = jwt.getClaim("roles").asString();
        return Arrays.asList(roles.replaceAll("[\\[\\]\"]", "").split(","));
    }

    private boolean isPublicPath(String path) {
        return this.publicPaths.stream().anyMatch(path::contains);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}