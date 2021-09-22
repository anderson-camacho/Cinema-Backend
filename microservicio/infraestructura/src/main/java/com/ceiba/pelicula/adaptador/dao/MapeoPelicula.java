package com.ceiba.pelicula.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class MapeoPelicula implements RowMapper<DtoPelicula>, MapperResult {

    @Override
    public DtoPelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String titulo = rs.getString("titulo");
        String director = rs.getString("director");


        return new DtoPelicula(id, titulo, director);
    }

}
