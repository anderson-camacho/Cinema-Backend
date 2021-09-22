package com.ceiba.pelicula.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPeliculaMysql implements RepositorioPelicula {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pelicula", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pelicula", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "pelicula", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "pelicula", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "pelicula", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;


    public RepositorioPeliculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pelicula pelicula) {
        return customNamedParameterJdbcTemplate.crear(pelicula, sqlCrear);
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        this.customNamedParameterJdbcTemplate.actualizar(pelicula, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String titulo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String titulo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, parameterSource, boolean.class);
    }
}
