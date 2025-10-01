package com.maximiliano.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.maximiliano.modelos.Artista;
import com.maximiliano.servicios.ServicioArtistas;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorArtistas {
    @Autowired
    private final ServicioArtistas servicioArtistas;

    public ControladorArtistas(ServicioArtistas servicioArtistas) {
        this.servicioArtistas = servicioArtistas;
    }

@GetMapping("/artistas")
public String desplegarArtistas(Model model) {
    model.addAttribute("artistas", this.servicioArtistas.obtenerTodosLosArtistas());
    return "artistas"; 
    }

@GetMapping("/artistas/detalle/{idArtista}")
public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista , Model model) {
    model.addAttribute("artista" , this.servicioArtistas.obtenerArtistaPorId(idArtista));
    return "detalleArtista";
}

@GetMapping("/artistas/formulario/agregar/{idArtista}")
public String formularioAgregarArtista(@PathVariable("idArtista") Long idArtista, @ModelAttribute("agregarArtista") Artista agregarArtista) {
    return "agregarArtista";
}

@PostMapping("/artistas/procesa/agregar")
public String procesarAgregarArtistas(@Valid @ModelAttribute("agregarArtista") Artista agregarArtista
                                    ,BindingResult resultados) {
    this.servicioArtistas.agregarArtista(agregarArtista);
    if (resultados.hasErrors()) {
        return "agregarArtista";
        
    }
    servicioArtistas.agregarArtista(agregarArtista);
    return "redirect:/artistas";
}
}

    

