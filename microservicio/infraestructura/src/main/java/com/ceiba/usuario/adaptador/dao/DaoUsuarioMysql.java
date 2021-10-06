package com.ceiba.usuario.adaptador.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.adaptador.dao.MapeoPelicula;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

@Component
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="listarUsuarios")
    private static String sqlListarUsuarios;
    @SqlStatement(namespace="usuario", value="consultarUsuario")
    private static String sqlConsultarUsuario;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuario> listarUsuario() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarUsuarios, new MapeoUsuario());
    }

    @Override
    public DtoUsuario consultarUsuarioId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", id);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlConsultarUsuario, parametros, new MapeoUsuario());
    }
}
