package com.itsqmet.repository;

import com.itsqmet.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface restauranteRepositorio extends JpaRepository <Restaurante , Long> {
    List<Restaurante> findByCategoriaContainingIgnoreCase(String nombre);
}
