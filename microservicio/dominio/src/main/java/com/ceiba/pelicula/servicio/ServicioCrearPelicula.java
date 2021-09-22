package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;

public class ServicioCrearPelicula {

    private static final String LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA = "La pelicula ya existe en el sistema";

    private final RepositorioPelicula repositorioPelicula;

    public ServicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public Long ejecutar(Pelicula pelicula){
        validarExistenciaPrevia(pelicula);
        return this.repositorioPelicula.crear(pelicula);
    }

    private void validarExistenciaPrevia(Pelicula pelicula) {
        boolean existe = this.repositorioPelicula.existe(pelicula.getTitulo());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
