package com.example.rs1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EjercicioBs2Application {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioBs2Application.class, args);
	}

	@Bean
	public List<PersonaService> crearlista() {

		List<PersonaService> lista = new ArrayList();

		System.out.println("lista creada");

		return lista;
	}
}