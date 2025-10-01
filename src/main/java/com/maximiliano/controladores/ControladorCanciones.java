package com.maximiliano.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.maximiliano.modelos.Artista;
import com.maximiliano.modelos.Cancion;
import com.maximiliano.servicios.ServicioArtistas;
import com.maximiliano.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
public class ControladorCanciones {
    @Autowired
    private final ServicioCanciones servicioCanciones;

    private final ServicioArtistas servicioArtistas;


    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
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
    public String formularioAgregarCancion(Model model) {
    model.addAttribute("nuevaCancion", new Cancion());
    model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas()); 
    return "agregarCancion";
}

    @PostMapping("/canciones/procesa/formulario")
    public String procesarAgregarCancion(@Valid @ModelAttribute("nuevaCancion") Cancion nuevaCancion,
                                        BindingResult validaciones, @RequestParam ("artistaId") Long artistaId) {
        if (validaciones.hasErrors()) {
            return "agregarCancion";
            
        }
        Artista artista = this.servicioArtistas.obtenerArtistaPorId(artistaId);
        if (artista != null) {
            nuevaCancion.setArtista(artista);
        }
        this.servicioCanciones.agregarCancion(nuevaCancion);
        
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
    
    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable ("idCancion") Long idCancion) {
        this.servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
    
}
