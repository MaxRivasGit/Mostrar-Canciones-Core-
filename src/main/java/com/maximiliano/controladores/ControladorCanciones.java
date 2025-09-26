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
import org.springframework.web.bind.annotation.RequestBody;





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
    
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("editaCancion", cancion);
            return "editarCancion";
        } else {
            return "redirect:/canciones";
        }
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
                                        @Valid @ModelAttribute("editaCancion") Cancion editaCancion,
                                        BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "editarCancion";
        }else {
            editaCancion.setId(idCancion);
            this.servicioCanciones.actualizaCancion(editaCancion);
            return "redirect:/canciones";
        }
    }
    
    
}
