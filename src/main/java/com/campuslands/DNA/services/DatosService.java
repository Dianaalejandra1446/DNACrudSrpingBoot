package com.campuslands.DNA.services;

import java.util.List;

import com.campuslands.DNA.repositories.entities.Datos;

public interface DatosService {
    List<Datos> finAll();

    Datos finById(Long id);

    Datos save(Datos datosPersona);

    void delete(Long id);

    void update(Long id, Datos datosActualizado);
}
