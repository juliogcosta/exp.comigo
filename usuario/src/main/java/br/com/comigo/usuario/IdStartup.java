package br.com.comigo.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = { 
    "br.com.comigo.usuario",
    "br.com.comigo.common.infrastructure.exception"
})
public class IdStartup {
	public static void main(String[] args) {
		SpringApplication.run(IdStartup.class, args);
	}
}
