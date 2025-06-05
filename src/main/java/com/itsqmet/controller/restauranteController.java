package com.itsqmet.controller;

import com.itsqmet.entity.Restaurante;
import com.itsqmet.service.restauranteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class restauranteController {
    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @Autowired
    private restauranteServicio restauranteServicio;

    @GetMapping("/listaMenu")
    public String listarPlatos(@RequestParam(name = "buscarPlato", required = false, defaultValue = "") String buscarPlato, Model model) {
        List<Restaurante> platos = restauranteServicio.buscarPlatoPorNombre(buscarPlato);
        model.addAttribute("platos", platos);
        model.addAttribute("buscarPlato", buscarPlato);
        return "pages/listaMenu";
    }

    @GetMapping("/formularioMenu")
    public String formularioLibro(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "pages/formularioMenu";
    }

    @PostMapping("/guardarLibro")
    public String crearLibro(Restaurante restaurante) {
        restauranteServicio.guardarPlato(restaurante);
        return "redirect:/listaMenu";
    }

    @GetMapping("/editarPlato/{id}")
    public String actualizarPlato(@PathVariable Long id, Model model) {
        Optional<Restaurante> plato = restauranteServicio.buscarPlatoPorId(id);
        model.addAttribute("plato", plato);
        return "pages/formularioMenu";
    }

    @GetMapping("/eliminarPlato/{id}")
    public String eliminarPLato(@PathVariable Long id, Model model) {
        restauranteServicio.eliminarPlato(id);
        return "redirect:/listaMenu";
    }

}