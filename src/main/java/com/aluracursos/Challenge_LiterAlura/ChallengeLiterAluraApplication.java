package com.aluracursos.Challenge_LiterAlura;

import com.aluracursos.Challenge_LiterAlura.principal.Principal;
import com.aluracursos.Challenge_LiterAlura.repository.AutorRepository;
import com.aluracursos.Challenge_LiterAlura.repository.LibroRepository;
import com.aluracursos.Challenge_LiterAlura.service.AutorService;
import com.aluracursos.Challenge_LiterAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, autorService, libroService);
		principal.muestraElMenu();
	}
}
