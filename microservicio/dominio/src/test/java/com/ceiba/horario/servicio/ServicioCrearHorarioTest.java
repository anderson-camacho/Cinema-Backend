package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearHorarioTest {
    private static final String EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA = "El horario ya existe en el sistema";

    @Test
    public void validarHorarioExistenciaPreviaTest() {
        // arrange
        Horario horario = new HorarioTestDataBuilder().build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearHorario servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHorario.ejecutar(horario), ExcepcionDuplicidad.class, EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarHorarioNoExistenciaPreviaTest() {
        // arrange
        Horario horario = new HorarioTestDataBuilder().conIdPelicula().build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearHorario servicioCrearHorario = new ServicioCrearHorario(repositorioHorario);
        // act - assert
        Assert.assertNotNull(servicioCrearHorario.ejecutar(horario));
     }
}


