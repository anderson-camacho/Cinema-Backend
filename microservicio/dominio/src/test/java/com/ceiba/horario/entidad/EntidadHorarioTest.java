package com.ceiba.horario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionFechaInvalida;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import org.junit.Test;

public class EntidadHorarioTest {

    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_EL_OBJETO_PELICULA = "Se debe ingresar el onjeto pelicula";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_MAYOR_A_HOY = "Se debe ingresar ela fecha mayor a hoy";
    private static final String SE_DEBE_INGRESAR_LOS_CUPOS = "Se debe ingresar los cupos";
    private static final String LOS_CUPOS_DEBEN_SER_MAYOR_A_0 = "lOS CUPOS DEBEN SER MAYOR A 0";

    @Test
    public void validarHorarioSinIdPelicula() {
        // Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().sinIdPelicula();

        // Act - Assert
        BasePrueba.assertThrows(() -> horarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_OBJETO_PELICULA);
    }

    @Test
    public void validarHorarioSinCupos() {
        // Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().sinCupos();

        // Act - Assert
        BasePrueba.assertThrows(() -> horarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_CUPOS);
    }

    @Test
    public void validarHorarioCuposMenosACero() {
        // Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().cuposMenorCero();

        // Act - Assert
        BasePrueba.assertThrows(() -> horarioTestDataBuilder.build(), ExcepcionValorInvalido.class, LOS_CUPOS_DEBEN_SER_MAYOR_A_0);
    }

    @Test
    public void validarHorarioSinFecha() {
        // Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().sinFecha();

        // Act - Assert
        BasePrueba.assertThrows(() -> horarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UNA_FECHA);
    }

    @Test
    public void validarHorarioFechaAnteriorAHoy() {
        // Arrange
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().fechaAnteriorAHoy();

        // Act - Assert
        BasePrueba.assertThrows(() -> horarioTestDataBuilder.build(), ExcepcionFechaInvalida.class, SE_DEBE_INGRESAR_LA_FECHA_MAYOR_A_HOY);
    }

}
