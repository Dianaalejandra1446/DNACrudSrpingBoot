package com.campuslands.DNA.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.DNA.repositories.entities.Datos;
import com.campuslands.DNA.services.DatosService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/analisis")
@AllArgsConstructor
public class DatosController {
    private DatosService datosService;

    @GetMapping("/all")
    public List<Datos> finAll(){
        return datosService.finAll();
    }

    @GetMapping("/{id}")
    public Datos finAllById(@PathVariable Long id){
        return datosService.finById(id);
    }
    @PostMapping("/save")
    public Datos save(@RequestBody Datos datosPersona){
        return datosService.save(datosPersona);
    }
    @DeleteMapping("/")
    public void delete(@RequestBody Long id){
        datosService.delete(id);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Datos datosPersona){
        datosService.update(id, datosPersona);
    }

    @GetMapping("/find-suspect")
    public Datos findSuspect(@RequestBody String cromosoma){
        return datosService.findSuspect(cromosoma);
    }
}
