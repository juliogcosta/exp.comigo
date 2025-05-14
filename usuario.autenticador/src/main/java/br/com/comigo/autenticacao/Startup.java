package br.com.comigo.autenticacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Configuration
@EnableWebSecurity
@SpringBootApplication
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
