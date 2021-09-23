package com.ceiba.horario.puerto.repositorio;

import com.ceiba.horario.modelo.entidad.Horario;

public interface RepositorioHorario {

    /**
     * Permite crear una horario
     * @param horario
     * @return el id generado
     */
    Long crear(Horario horario);

    /**
     * Permite eliminar una horario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un horario
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);


}
