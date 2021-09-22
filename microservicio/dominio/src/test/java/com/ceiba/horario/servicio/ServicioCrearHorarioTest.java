package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ServicioCrearHorarioTest {

    @Test
    public void validarCupoNegativoTest() {
        HorarioTestDataBuilder horarioTestDataBuilder = new HorarioTestDataBuilder().conCupo(-1L);
        BasePrueba.assertThrows(
                () -> horarioTestDataBuilder.build(),
                ExcepcionValorInvalido.class, "El usuario ya existe en el sistema");
    }
}
