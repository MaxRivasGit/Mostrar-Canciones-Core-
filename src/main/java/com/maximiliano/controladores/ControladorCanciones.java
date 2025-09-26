package com.maximiliano.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.maximiliano.modelos.Cancion;
import com.maximiliano.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ControladorCanciones {

    @Autowired
    private final ServicioCanciones servicioCanciones;
    
    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", this.servicioCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }
    
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        model.addAttribute("cancion", this.servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute ("nuevaCancion") Cancion nuevaCancion) {
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/formulario")
    public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "agregarCancion";
            
        }
        
        return "redirect:/canciones";
    }
    
    
}
