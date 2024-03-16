package com.campuslands.DNA.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "datos")
// Clase representa una tabla en la base de datos.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    private String direccion;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String cromosoma;
}
