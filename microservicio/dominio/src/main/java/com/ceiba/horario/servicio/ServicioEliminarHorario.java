package com.ceiba.horario.servicio;

import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioEliminarHorario {

    private final RepositorioHorario repositorioHorario;

    public ServicioEliminarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Long id) {
        this.repositorioHorario.eliminar(id);
    }

}
