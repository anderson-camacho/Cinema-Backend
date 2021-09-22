package com.ceiba.pelicula.servicio;

import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

public class ServicioEliminarPelicula {

    private final RepositorioPelicula repositorioPelicula;

    public ServicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public void ejecutar(Long id) {

        this.repositorioPelicula.eliminar(id);
    }
}
