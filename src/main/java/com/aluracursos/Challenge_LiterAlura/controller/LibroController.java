package com.aluracursos.Challenge_LiterAlura.controller;

import com.aluracursos.Challenge_LiterAlura.service.LibroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private LibroService servicio;

    @GetMapping("")
    public List<String> obtenerTodosLosLibros(){
        return servicio.obtenerTodosLosLibros();
    }
}
