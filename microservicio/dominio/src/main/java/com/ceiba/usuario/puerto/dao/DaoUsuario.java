package com.ceiba.usuario.puerto.dao;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listarUsuario();
    DtoUsuario consultarUsuarioId(Long id);
}
