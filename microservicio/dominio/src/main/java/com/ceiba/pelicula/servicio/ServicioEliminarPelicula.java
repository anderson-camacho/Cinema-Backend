package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioEliminarPelicula {

    private static final String LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS = "La pelicula esta agendada en los horarios";

    private final RepositorioPelicula repositorioPelicula;
    private final RepositorioHorario repositorioHorario;


    public ServicioEliminarPelicula(RepositorioPelicula repositorioPelicula, RepositorioHorario repositorioHorario) {
        this.repositorioPelicula = repositorioPelicula;
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Long id) {
        validarExistenciaPeliculaEnHorario(id);
        this.repositorioPelicula.eliminar(id);
    }

    private void validarExistenciaPeliculaEnHorario(Long id) {
        boolean existe = this.repositorioHorario.existePelicula(id);
        if (existe) {
            throw new ExcepcionExiste(LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS);
        }
    }
}
