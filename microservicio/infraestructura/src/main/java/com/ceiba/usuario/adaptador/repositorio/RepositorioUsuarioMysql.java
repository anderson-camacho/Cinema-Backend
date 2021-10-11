package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "usuario", value = "crearUsuario")
    private static String sqlCrearUsuario;

    @SqlStatement(namespace = "usuario", value = "actualizarUsuario")
    private static String sqlActualizarUsuario;

    @SqlStatement(namespace = "usuario", value = "eliminarUsuario")
    private static String sqlEliminarUsuario;

    @SqlStatement(namespace = "usuario", value = "existeUsuario")
    private static String sqlExisteUsuario;

    @SqlStatement(namespace = "usuario", value = "existeExcluyendoIdUsuario")
    private static String sqlExisteExcluyendoIdUsuario;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Usuario usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrearUsuario);
    }

    @Override
    public void eliminar(Long id) {
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarUsuario, construccionParamSource(id));
    }

    @Override
    public boolean existe(Long id) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteUsuario, construccionParamSource(id), Boolean.class);
    }

    @Override
    public void actualizar(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizarUsuario);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExisteExcluyendoIdUsuario, construccionParamSource(id, nombre), Boolean.class);
    }

    private MapSqlParameterSource construccionParamSource(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return paramSource;
    }

    private MapSqlParameterSource construccionParamSource(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);
        return paramSource;
    }
}
