package br.com.comigo.autenticador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableFeignClients
@EnableWebSecurity
@ComponentScan(basePackages = { "br.com.comigo.common" })
@SpringBootApplication
public class AuthStartup {
	public static void main(String[] args) {
		SpringApplication.run(AuthStartup.class, args);
	}
}
