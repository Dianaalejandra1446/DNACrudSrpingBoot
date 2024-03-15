package com.campuslands.DNA.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.DNA.repositories.RepositoryDatos;
import com.campuslands.DNA.repositories.entities.Datos;
import com.campuslands.DNA.services.DatosService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DatosServiceImpl implements DatosService{

    private RepositoryDatos repositoryDatos;

    @Override
    @Transactional
    public List<Datos> finAll() {
        return (List<Datos>)repositoryDatos.findAll();
    }

    @Override
    @Transactional
    public Datos finById(Long id) {
        return repositoryDatos.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Datos save(Datos datosPersona) {
        return repositoryDatos.save(datosPersona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Datos> eliminarDatos=repositoryDatos.findById(id);
        if (eliminarDatos.isPresent()) {
            repositoryDatos.delete(eliminarDatos.get());
        }
    }

    @Override
    @Transactional
    public void update(Long id, Datos datosActualizado) {
        Optional<Datos> buscarPersona = repositoryDatos.findById(id);
        if (buscarPersona.isPresent()) {
            Datos personaExistente = buscarPersona.get();
            personaExistente.setNombre(datosActualizado.getNombre());
            personaExistente.setApellido(datosActualizado.getApellido());
            personaExistente.setDireccion(datosActualizado.getDireccion());
            personaExistente.setEmail(datosActualizado.getEmail());
            personaExistente.setCromosoma(datosActualizado.getCromosoma());
        }
    }

    @Override
    public Datos findSuspect(String cromosoma) {
        Optional<Datos> encontrarCromosoma = repositoryDatos.findSuspect(cromosoma);
    }
    
}
