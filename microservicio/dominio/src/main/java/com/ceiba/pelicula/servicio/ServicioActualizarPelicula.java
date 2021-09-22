package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioActualizarPelicula {

    private static final String LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioPelicula repositorioPelicula;

    public ServicioActualizarPelicula(RepositorioPelicula repositorioPelicula){
        this.repositorioPelicula = repositorioPelicula;
    }

    public void ejecutar(Pelicula pelicula) {
        validarExistenciaPrevia(pelicula);
        this.repositorioPelicula.actualizar(pelicula);
    }

    private void validarExistenciaPrevia(Pelicula pelicula) {
        boolean existe = this.repositorioPelicula.existeExcluyendoId(pelicula.getId(),pelicula.getTitulo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
