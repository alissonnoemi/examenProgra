package com.itsqmet.service;

import com.itsqmet.entity.Restaurante;
import com.itsqmet.repository.restauranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class restauranteServicio {
    @Autowired
    private restauranteRepositorio restauranteRepositorio;

    public List<Restaurante> mostrarMenú() {
        return restauranteRepositorio.findAll();
    }

    public List<Restaurante> buscarPlatoPorNombre(String buscarPlato) {
        if (buscarPlato == null || buscarPlato.isEmpty()) {
            return restauranteRepositorio.findAll();
        } else {
            return restauranteRepositorio.findByNombreContainingIgnoreCase(buscarPlato);
        }
    }

    public Optional<Restaurante> buscarPlatoPorId(Long id) {
        return restauranteRepositorio.findById(id);
    }

    public Restaurante guardarPlato(Restaurante restaurante) {
        return restauranteRepositorio.save(restaurante);
    }

    public void eliminarPlato(Long id) {
        restauranteRepositorio.deleteById(id);
    }

}
