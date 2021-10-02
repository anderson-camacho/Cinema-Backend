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

    @SqlStatement(namespace = "pelicula", value = "crearPelicula")
    private static String sqlCrearPelicula;

    @SqlStatement(namespace = "pelicula", value = "actualizarPelicula")
    private static String sqlActualizarPelicula;

    @SqlStatement(namespace = "pelicula", value = "eliminarPelicula")
    private static String sqlEliminarPelicula;

    @SqlStatement(namespace = "pelicula", value = "existePelicula")
    private static String sqlExistePelicula;

    @SqlStatement(namespace = "pelicula", value = "existeExcluyendoIdPelicula")
    private static String sqlExisteExcluyendoIdPelicula;

    public RepositorioPeliculaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pelicula pelicula) {
        return customNamedParameterJdbcTemplate.crear(pelicula, sqlCrearPelicula);
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        this.customNamedParameterJdbcTemplate.actualizar(pelicula, sqlActualizarPelicula);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPelicula, parameterSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlExistePelicula, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String titulo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("titulo", titulo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoIdPelicula, parameterSource, boolean.class);
    }

}
