package br.edu.christus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Backend - API User-Address",
				version = "1.0",
				description = "Trata-se de uma API construída nas aulas " +
						"da disciplina TEPW",
				contact = @Contact(
						name = "Adriano Lima",
						email = "analista.adrianolima@gmail.com",
						url = "https://www.exemplo.com")
		)
)
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
