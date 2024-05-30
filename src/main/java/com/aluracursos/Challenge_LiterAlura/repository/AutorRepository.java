package com.aluracursos.Challenge_LiterAlura.repository;

import com.aluracursos.Challenge_LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libros WHERE a.id = :id")
    Optional<Autor> findByIdWithLibros(@Param("id") Long id);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :year AND (a.deceso IS NULL OR a.deceso > :year)")
    List<Autor> findAutoresVivosEnAno(@Param("year") String year);
}
