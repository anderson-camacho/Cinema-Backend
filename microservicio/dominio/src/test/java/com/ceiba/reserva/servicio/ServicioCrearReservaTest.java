package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinCupos;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {
    private static final String LA_RESERVA_YA_EXISTE = "La reserva ya existe para este usuario";
    private static final String NO_HAY_CUPOS_EN_EL_HORARIO = "No hay cupos en el horario";

    @Test
    public void validarExistenciaDeReservaUsusarioTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conId(12L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioReserva.usuarioYaReservo(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, LA_RESERVA_YA_EXISTE);
    }

    @Test
    public void validarExistenciaDeCuposEnHorarioTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().connIdHorario(3L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.cuposRestantes(Mockito.anyLong())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionSinCupos.class, NO_HAY_CUPOS_EN_EL_HORARIO);
    }
}
