package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;
import java.util.UUID;

public class ServicioCrearHorarioTest {

    /*@Test
    public void validarHorarioCrearHorario() {
        // Arrange
        Horario horario = new HorarioTestDataBuilder().build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearHorario servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);



        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionValorObligatorio.class, "");
    }*/

}
