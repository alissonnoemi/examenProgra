package com.itsqmet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    @Size(min=3, max=30)
    private String nombre;
    @Size(min = 10, max = 100, message = "La descripción debe tener entre 10 y 100 caracteres")
    private String descripcion;
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "El precio debe ser un número válido")
    private String precio;
    @Size(min = 3, max = 30, message = "La categoría debe tener entre 3 y 30 caracteres")
    private String categoria;
    private String disponibilidad;

}
