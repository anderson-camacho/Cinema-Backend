package com.ceiba.pelicula.servicio.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public class PeliculaTestDataBuilder {
    private Long id;
    private String titulo;
    private String director;

    public PeliculaTestDataBuilder() {
        this.titulo = "Rapidos_y_Furiosos";
        director = "Volado_De_La_Cabeza";
    }

    public PeliculaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public PeliculaTestDataBuilder sinTitulo( ){
        this.titulo = null;
        return this;
    }


    public PeliculaTestDataBuilder sinDirector( ){
        this.director = null;
        return this;
    }


    public Pelicula build(){
        return new Pelicula(this.id, this.titulo, this.director);
    }
}
