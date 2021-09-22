package com.ceiba.pelicula.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

public class ServicioEliminarPelicula {

    private static final String LA_PELICULA_NO_EXISTE = "La pelicula no existe";

    private final RepositorioPelicula repositorioPelicula;

    public ServicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
        this.repositorioPelicula = repositorioPelicula;
    }

    public void ejecutar(Long id){
        validarNoExistenciaPrevia(id);
        this.repositorioPelicula.eliminar(id);
    }

    private void validarNoExistenciaPrevia(Long id) {
        boolean existe = this.repositorioPelicula.existe(id);
        if(!existe) {
            throw new ExcepcionExiste(LA_PELICULA_NO_EXISTE);
        }
    }
}
