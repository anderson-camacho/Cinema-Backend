/**
 * @author Anderson Camacho Palacios
 * @Email anderson.camacho@ceiba.com.co
 */
package com.ceiba.pelicula.puerto.dao;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;

import java.util.List;

public interface DaoPelicula {
    List<DtoPelicula> listar();
    DtoPelicula consultarPeliculaId(Long id);
}
