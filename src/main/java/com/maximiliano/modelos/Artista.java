package com.maximiliano.modelos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="artistas")
public class Artista {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String biografia;


    @Temporal(TemporalType.TIMESTAMP)
    @Column (name="fecha_creacion")
    private Date fechaDeCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "fecha_actualizacion")
    private Date fechaDeActualizacion;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    List<Cancion> canciones;

    @Override
    public String toString() {
    return nombre + " " + apellido;
}


    public Artista() {
    }



        public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getBiografia() {
        return biografia;
    }



    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }



    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }



    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }



    public Date getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }



    public void setFechaDeActualizacion(Date fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }



    public List<Cancion> getCanciones() {
        return canciones;
    }



    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }



        @PrePersist
    protected void onCreate(){
        this.fechaDeCreacion = new Date();
        this.fechaDeActualizacion = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.fechaDeActualizacion = new Date();
    }
}
