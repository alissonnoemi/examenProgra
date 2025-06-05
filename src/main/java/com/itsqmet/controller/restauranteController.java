package com.itsqmet.controller;

import com.itsqmet.entity.Restaurante;
import com.itsqmet.service.restauranteServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class restauranteController {
    @Autowired
    private restauranteServicio restauranteServicio;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/listaMenu")
    public String listarPlatos(@RequestParam(name = "buscarPlato", required = false, defaultValue = "") String buscarPlato, Model model) {
        List<Restaurante> platos = restauranteServicio.buscarPlatoPorCategoria(buscarPlato);
        model.addAttribute("platos", platos);
        model.addAttribute("buscarPlato", buscarPlato);
        return "pages/listaMenu";
    }

    @GetMapping("/formularioMenu")
    public String formularioPlato(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        return "pages/formularioMenu";
    }

    @PostMapping("/guardarPlato")
    public String guardarPlato(@Valid @ModelAttribute Restaurante restaurante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "pages/formularioMenu";
        }
        restauranteServicio.guardarPlato(restaurante);
        return "redirect:/listaMenu";
    }

    @GetMapping("/editarPlato/{id}")
    public String editarPlato(@PathVariable Long id, Model model) {
        Optional<Restaurante> plato = restauranteServicio.buscarPlatoPorId(id);
        model.addAttribute("restaurante", plato.orElse(new Restaurante()));
        return "pages/formularioMenu";
    }

    @GetMapping("/eliminarPlato/{id}")
    public String eliminarPlato(@PathVariable Long id) {
        restauranteServicio.eliminarPlato(id);
        return "redirect:/listaMenu";
    }

}