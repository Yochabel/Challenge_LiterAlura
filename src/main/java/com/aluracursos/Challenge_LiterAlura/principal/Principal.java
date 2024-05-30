package com.aluracursos.Challenge_LiterAlura.principal;

import com.aluracursos.Challenge_LiterAlura.dto.LibroDTO;
import com.aluracursos.Challenge_LiterAlura.model.Autor;
import com.aluracursos.Challenge_LiterAlura.model.Libro;
import com.aluracursos.Challenge_LiterAlura.repository.LibroRepository;
import com.aluracursos.Challenge_LiterAlura.service.AutorService;
import com.aluracursos.Challenge_LiterAlura.service.LibroService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";
    private LibroRepository libroRepository;
    private LibroService libroService;
    private AutorService autorService;

    @Autowired
    public Principal(LibroRepository libroRepository, AutorService autorService, LibroService libroService) {
        this.libroRepository = libroRepository;
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    \nElige la opción que desees!\n
                    1.- Buscar libro por titulo
                    2.- Listar libros registrados
                    3.- Listar autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma
                    0.- Salir\n
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosEnAnio();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar la aplicación!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Introduce el título del libro: ");
        var tituloLibro = teclado.nextLine();
        List<Libro> libro = libroService.obtenerLibroPorTitulo(tituloLibro);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public void listarLibros() {
        List<String> libros = libroService.obtenerTodosLosLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (String libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void listarAutores() {
        List<Autor> autores = autorService.findAllAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
    }

    public void listarAutoresVivosEnAnio() {
        System.out.print("Introduce el año a buscar: ");
        var anioBuscado = teclado.nextLine();
        List<Autor> autores = autorService.findAutoresVivosEnAnio(anioBuscado);
        if (autores.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + anioBuscado);
        } else {
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
    }

    public void listarLibrosPorIdioma() {
        System.out.print("Introduce el idioma a buscar (en o tl): ");
        String idiomaBuscado = teclado.nextLine();  // Captura el idioma buscado
        List<Libro> libros = libroService.findByIdioma(idiomaBuscado);  // Usa la variable correcta
        if (libros.isEmpty()) {
            System.out.println("No hay libros en el idioma " + idiomaBuscado);
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}

