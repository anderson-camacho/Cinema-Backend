package com.ceiba.pelicula.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;

import java.util.List;

public class DaoPeliculaMysql implements DaoPelicula {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "usuario", value = "listar")
    private static String sqlListar;

    public DaoPeliculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoPelicula> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPelicula());
    }
}
