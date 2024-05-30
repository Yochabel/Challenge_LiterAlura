package com.aluracursos.Challenge_LiterAlura.service;

import com.aluracursos.Challenge_LiterAlura.model.*;
import com.aluracursos.Challenge_LiterAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private IConvierteDatos convierteDatos;

    public List<Libro> obtenerLibroPorTitulo(String tituloLibro) {
        return libroRepository.findByTituloContainsIgnoreCase(tituloLibro);
    }

    public List<String> obtenerTodosLosLibros() {
        List<Libro> libros = libroRepository.findAll();
        return convierteDatos(libros);
    }

    public List<Libro> findByIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    private List<String> convierteDatos(List<Libro> libros) {
        return libros.stream()
                .map(libro -> {
                    Autor autor = libro.getAutor();
                    if (autor != null) {
                        return String.format("Libro: ID= %d, Titulo= '%s', Autor ID= %d, Nombre= '%s'",
                                libro.getId(), libro.getTitulo(), autor.getId(), autor.getNombre());
                    } else {
                        return String.format("Libro: ID= %d, titulo= '%s', Autor ID= No asignado",
                                libro.getId(), libro.getTitulo());
                    }
                })
                .collect(Collectors.toList());
    }
}
