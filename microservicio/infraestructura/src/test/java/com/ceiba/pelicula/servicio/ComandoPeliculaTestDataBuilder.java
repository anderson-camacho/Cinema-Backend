package com.ceiba.pelicula.servicio;

import com.ceiba.pelicula.comando.ComandoPelicula;

public class ComandoPeliculaTestDataBuilder {

    private Long id;
    private String titulo;
    private String director;

    public ComandoPeliculaTestDataBuilder(){
        this.titulo = "blancanieves";
        this.director = "Anderson";
    }

    public ComandoPeliculaTestDataBuilder conTitulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public ComandoPelicula build(){
        return new ComandoPelicula(this.id, this.titulo, this.director);
    }
}
