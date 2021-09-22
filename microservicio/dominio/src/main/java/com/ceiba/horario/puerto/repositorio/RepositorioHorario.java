package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

public interface RepositorioHorario {

    /**
     * Permite crear una horario
     * @param horario
     * @return el id generado
     */
    Long crear(Horario horario);

    /**
     * Permite actualizar una horario
     * @param horario
     */
    void actualizar(Horario horario);

    /**
     * Permite eliminar una horario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un horario
     * @param pelicula
     * @return si existe o no
     */
    boolean existe(Pelicula pelicula);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param id
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombrePelicula);
}
