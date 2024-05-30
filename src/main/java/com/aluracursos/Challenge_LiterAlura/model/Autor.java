package com.aluracursos.Challenge_LiterAlura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int fechaDeNacimiento;
    private int deceso;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
        // Constructor por defecto
    }

    public Autor(String nombre, int fechaDeNacimiento, int deceso) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.deceso = deceso;
    }

    public List<Libro> getLibros() {
        if (libros == null) {
            libros = new ArrayList<>();
        }
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(int fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getDeceso() {
        return deceso;
    }

    public void setDeceso(int deceso) {
        this.deceso = deceso;
    }

    @Override
    public String toString() {
        return "Autor:" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", deceso='" + deceso;
    }
}
