package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {
    /**
     * Permite crear una pelicula
     *
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);


    /**
     * Permite eliminar una pelicula
     *
     * @param id
     */
    void eliminar(Long id);


    /**
     * Permite validar si existe un usuario con un nombre
     *
     * @param id
     * @return si existe o no
     */

    boolean existe(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     *
     * @param idUsuario
     * @return si existe o no
     */
    boolean existeUsuario(Long idUsuario);

    /**
     * Permite validar si existe un usuario con un nombre
     *
     * @param idUsuario
     * @return si existe o no
     */
    boolean usuarioYaReservo(Long idUsuario, Long idHorario);

}
