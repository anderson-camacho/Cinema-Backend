package com.ceiba.horario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioEliminarHorario {

    private static final String EL_HORARIO_NO_EXISTE = "El horario no existe";

    private final RepositorioHorario repositorioHorario;

    public ServicioEliminarHorario(RepositorioHorario repositorioHorario) {
        this.repositorioHorario = repositorioHorario;
    }

    public void ejecutar(Long id) {
        validarNoExistenciaPrevia(id);
        this.repositorioHorario.eliminar(id);
    }

    private void validarNoExistenciaPrevia(Long id) {
        boolean existe = this.repositorioHorario.existe(id);
        if(!existe) {
            throw new ExcepcionExiste(EL_HORARIO_NO_EXISTE);
        }
    }

}
