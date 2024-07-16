package com.aluracursos.conversormoneda;

import com.aluracursos.conversormoneda.model.DatosMoneda;
import com.aluracursos.conversormoneda.principal.Principal;
import com.aluracursos.conversormoneda.service.ConsumoApi;
import com.aluracursos.conversormoneda.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class ConversormonedaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversormonedaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.mostrarMenu();


	}
}







