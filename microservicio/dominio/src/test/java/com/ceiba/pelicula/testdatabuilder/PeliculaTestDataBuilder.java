package com.ceiba.pelicula.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

import java.util.UUID;

public class PeliculaTestDataBuilder {
    private Long id;
    private String titulo;
    private String director;

    public PeliculaTestDataBuilder() {
        this.titulo = UUID.randomUUID().toString();
        director = UUID.randomUUID().toString();
    }

    public PeliculaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PeliculaTestDataBuilder sinTitulo() {
        this.titulo = null;
        return this;
    }


    public PeliculaTestDataBuilder sinDirector() {
        this.director = null;
        return this;
    }


    public Pelicula build() {
        return new Pelicula(this.id, this.titulo, this.director);
    }
}
