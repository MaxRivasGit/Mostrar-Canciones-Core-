package com.maximiliano.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximiliano.modelos.Artista;
import com.maximiliano.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
    @Autowired

    private final RepositorioArtistas repositorioArtistas;
    public ServicioArtistas(RepositorioArtistas repositorioArtistas) {
        this.repositorioArtistas = repositorioArtistas;
    }

    public List <Artista> obtenerTodosLosArtistas() {
        return this.repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId (Long id) {
        Artista artista = repositorioArtistas.findById(id).orElse(null);
    if (artista != null) {
        artista.getCanciones().size(); 
    }
    return artista;
}

    public Artista agregarArtista(Artista artista) {
        return this.repositorioArtistas.save(artista);
    }
}
