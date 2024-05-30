package com.aluracursos.Challenge_LiterAlura.service;

import com.aluracursos.Challenge_LiterAlura.model.Autor;
import com.aluracursos.Challenge_LiterAlura.repository.AutorRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor findAutorById(Long id) {
        return autorRepository.findByIdWithLibros(id)
                .orElseThrow(() -> new RuntimeException("Autor not found"));
    }

    public List<Autor> findAllAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> findAutoresVivosEnAnio(String year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }
}
