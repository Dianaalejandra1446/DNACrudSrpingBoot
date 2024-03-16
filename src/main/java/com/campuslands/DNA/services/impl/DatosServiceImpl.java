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
        // Obtener la lista de todas las personas
        return (List<Datos>)repositoryDatos.findAll();
    }

    @Override
    @Transactional
    public Datos finById(Long id) {
        // Encontrar por el Id
        return repositoryDatos.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Datos save(Datos datosPersona) {
        // Guardar datos persona
        return repositoryDatos.save(datosPersona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // Encontrar id
        Optional<Datos> eliminarDatos=repositoryDatos.findById(id);
        if (eliminarDatos.isPresent()) {
            // Eliminar la persona
            repositoryDatos.delete(eliminarDatos.get());
        }
    }

    @Override
    @Transactional
    public void update(Long id, Datos datosActualizado) {
        // Buscar la persona
        Optional<Datos> buscarPersona = repositoryDatos.findById(id);
        if (buscarPersona.isPresent()) {
            // Obtener la persona
            Datos personaExistente = buscarPersona.get();
            // Actualizar datos
            personaExistente.setNombre(datosActualizado.getNombre());
            personaExistente.setApellido(datosActualizado.getApellido());
            personaExistente.setDireccion(datosActualizado.getDireccion());
            personaExistente.setEmail(datosActualizado.getEmail());
            personaExistente.setCromosoma(datosActualizado.getCromosoma());
        }
    }
@Override
@Transactional
public Datos findSuspect(String cromosoma) {
    // Obtener la lista de todas las personas
    List<Datos> personas = finAll();
    
    // minimos genes iguales
    int maxGenesIguales = 0;
    // Almacenar sospechoso
    Datos sospechoso = null;

    // Recorrer la lista de personas para encontrar al sospechoso
    for (Datos persona : personas) {
        // Obtener el cromosoma de la persona actual
        String cromosomaPersona = persona.getCromosoma();
        
        // Inicializar un contador para los genes iguales
        int genesIguales = 0;

        // Comparar el cromosoma de la persona con la muestra proporcionada
        for (int i = 0; i < cromosoma.length(); i++) {
            if (cromosoma.charAt(i) == cromosomaPersona.charAt(i)) {
                genesIguales++;
            }
        }

        // Actualizar el sospechoso si se encuentra uno con más genes iguales
        if (genesIguales > maxGenesIguales) {
            maxGenesIguales = genesIguales;
            sospechoso = persona;
        }
    }

    // Calcular el porcentaje de parentesco basado en el número máximo de genes iguales
    double porcentajeParentesco = (double) maxGenesIguales / cromosoma.length() * 100;

    // Imprimir el nombre del sospechoso y el porcentaje de parentesco
    System.out.println("Sospechoso: " + sospechoso.getNombre() + " " + sospechoso.getApellido() +
            ", Porcentaje de parentesco: " + porcentajeParentesco + "%");

    // Devolver el objeto Datos del sospechoso encontrado
    return sospechoso;
}

    
}
