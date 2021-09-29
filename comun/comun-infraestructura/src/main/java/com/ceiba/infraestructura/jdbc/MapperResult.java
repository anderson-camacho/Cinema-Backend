package com.ceiba.infraestructura.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

public interface MapperResult {

	default LocalDate extraerLocalDate(ResultSet resultSet, String label) throws SQLException {
        Timestamp fecha = resultSet.getTimestamp(label);
        LocalDate resultado = null;
        if (!resultSet.wasNull()) {
            resultado = fecha.toLocalDateTime().toLocalDate();
        }
        return resultado;
    } 
	
	default LocalDate extraerLocalDateTime(ResultSet resultSet, String label) throws SQLException {
        Timestamp fecha = resultSet.getTimestamp(label);
        LocalDate resultado = null;
        if (!resultSet.wasNull()) {
            resultado = fecha.toLocalDateTime().toLocalDate();
        }
        return resultado;
    } 
}
