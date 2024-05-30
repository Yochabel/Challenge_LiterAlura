package com.aluracursos.Challenge_LiterAlura.dto;

import com.aluracursos.Challenge_LiterAlura.model.Autor;

public record LibroDTO(Long id,
                       String titulo,
                       String autor,
                       String idioma,
                       Double numeroDeDescargas) {
}
