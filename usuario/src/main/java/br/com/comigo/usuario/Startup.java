package br.com.comigo.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import feign.Contract;

@EnableFeignClients
@SpringBootApplication
public class Startup {
	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

    @Bean
    Contract feignContract()
    {
        return new feign.Contract.Default();
    }

    @Bean
    WebMvcConfigurer corsConfigurer() 
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) 
            {
                registry.addMapping("/**")
                    .allowCredentials(true)
                    .allowedOriginPatterns("*")
                    .allowedHeaders(
                            HttpHeaders.ORIGIN,
                            HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
                            HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
                            HttpHeaders.AUTHORIZATION,
                            HttpHeaders.CONTENT_TYPE,
                            HttpHeaders.ACCEPT)
                    .allowedMethods(
                            HttpMethod.POST.name(), 
                            HttpMethod.GET.name(), 
                            HttpMethod.PUT.name(), 
                            HttpMethod.DELETE.name(), 
                            HttpMethod.OPTIONS.name());
            }
        };
    }
}
