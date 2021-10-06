package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoReservaMysql implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "reserva", value = "listarReserva")
    private static String sqlListarReserva;

    @SqlStatement(namespace = "reserva", value = "consultarReserva")
    private static String sqlConsultarReserva;

    public DaoReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listarReserva() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarReserva, new MapeoReserva());
    }

    @Override
    public DtoReserva consultarReservaId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlConsultarReserva, parametros, new MapeoReserva());
    }
}
