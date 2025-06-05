package com.itsqmet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 100, message = "La descripción debe tener entre 10 y 100 caracteres")
    private String descripcion;

    @NotBlank(message = "El precio es obligatorio")
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "El precio debe ser un número válido")
    private String precio;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(min = 3, max = 30, message = "La categoría debe tener entre 3 y 30 caracteres")
    private String categoria;

    @NotBlank(message = "La disponibilidad es obligatoria")
    private String disponibilidad;
}