package com.ceiba.pelicula.puerto.dao;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoPelicula {
    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoPelicula> listar();
}
