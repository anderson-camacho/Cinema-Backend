package com.ceiba.horario.adaptador.repositorio;


import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHorarioMysql implements RepositorioHorario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "horario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "horario", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "horario", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "horario", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "horario", value = "existePelicula")
    private static String sqlExistePelicula;

    @SqlStatement(namespace = "horario", value = "seReservo")
    private static String sqlSeReservo;

    @SqlStatement(namespace = "horario", value = "cuposRestantes")
    private static String sqlCuposRestantes;

    public RepositorioHorarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Horario horario) {

        return customNamedParameterJdbcTemplate.crear(horario, sqlCrear);
    }


    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existePelicula(Long idPelicula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idPelicula", idPelicula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePelicula, parameterSource, Boolean.class);
    }

    @Override
    public void seReservo(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        Long cupos = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCuposRestantes,parameterSource,Long.class);
        cupos = cupos - 1;
        parameterSource.addValue("cupos", cupos);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlSeReservo, parameterSource);
    }

    @Override
    public Boolean cuposRestantes(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCuposRestantes, parameterSource, Boolean.class);
    }

}
