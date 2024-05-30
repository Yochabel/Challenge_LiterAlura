package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainsIgnoreCase(String tituloLibro);

    List<Libro> findByIdioma(String idioma);

}
