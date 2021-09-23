package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idUsuario = rs.getLong("idUsuario");
        Long idHorario = rs.getLong("idHorario");
        return new DtoReserva(id, idUsuario, idHorario);
    }
}
