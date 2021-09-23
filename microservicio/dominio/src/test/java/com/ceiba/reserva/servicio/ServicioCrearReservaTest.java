package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {
    private static final String LA_RESERVA_YA_EXISTE = "La reserva ya existe";

    @Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, LA_RESERVA_YA_EXISTE);
    }
}
