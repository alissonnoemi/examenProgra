package com.itsqmet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nombre;
    private String descripcion;
    private String precio;
    private String categoria;
    private String disponibilidad;

}
