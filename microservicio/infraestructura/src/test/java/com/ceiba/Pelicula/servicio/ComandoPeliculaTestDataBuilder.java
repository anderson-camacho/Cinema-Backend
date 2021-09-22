package com.ceiba.Pelicula.servicio;

import com.ceiba.pelicula.comando.ComandoPelicula;

import java.util.UUID;

public class ComandoPeliculaTestDataBuilder {

    private Long id;
    private String titulo;
    private String director;

    public ComandoPeliculaTestDataBuilder(){
//        titulo = UUID.randomUUID().toString();
//        director = UUID.randomUUID().toString();
        this.titulo = "blancanieves";
        this.director = "tomas";
    }

    public ComandoPeliculaTestDataBuilder conTitulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public ComandoPelicula build(){
        return new ComandoPelicula(this.id, this.titulo, this.director);
    }
}
