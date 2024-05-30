package com.aluracursos.Challenge_LiterAlura.service;

import com.aluracursos.Challenge_LiterAlura.model.DatosLibro;

import java.io.IOException;
import java.util.List;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
