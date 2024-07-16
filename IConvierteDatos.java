package com.aluracursos.conversormoneda.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class <T> clase);
}
