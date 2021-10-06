package com.ceiba.horario.adaptador.dao;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoHorarioMysql implements DaoHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "horario", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "horario", value = "consultarHorario")
    private static String sqlConsultarHorario;

    public DaoHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoHorario> listarHorariosConFechaSuperiorAHoy() {

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoHorario());
    }

    @Override
    public DtoHorario consultarHorarioId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlConsultarHorario, parametros, new MapeoHorario());
    }
}
