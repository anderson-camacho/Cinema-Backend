package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarReservaTest {
    private static final String LA_RESERVA_NO_EXISTE = "La reserva no existe";

    @Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conId(5L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarReserva.ejecutar(1L), ExcepcionExiste.class, LA_RESERVA_NO_EXISTE);
    }
}
