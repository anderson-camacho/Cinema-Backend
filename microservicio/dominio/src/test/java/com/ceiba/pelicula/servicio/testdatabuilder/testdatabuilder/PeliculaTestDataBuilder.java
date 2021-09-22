package com.ceiba.pelicula.servicio.testdatabuilder.testdatabuilder;

import com.ceiba.pelicula.modelo.entidad.Pelicula;

public class PeliculaTestDataBuilder {
    private Long id;
    private String titulo;
    private String Director;

    public PeliculaTestDataBuilder() {
        this.titulo = "Rapidos_y_Furiosos";
        Director = "Volado_De_La_Cabeza";
    }

    public PeliculaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }
    public Pelicula build(){
        return new Pelicula(this.id, this.titulo, this.Director);
    }
}
