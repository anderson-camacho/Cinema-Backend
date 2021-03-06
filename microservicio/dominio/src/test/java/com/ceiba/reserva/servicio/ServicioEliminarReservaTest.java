package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
        BasePrueba.assertThrows(() -> servicioEliminarReserva.ejecutar(5L), ExcepcionExiste.class, LA_RESERVA_NO_EXISTE);
    }

    @Test
    public void validarPeliculaNoExistenciaPreviaTest() {
        // arrange
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarReserva.ejecutar(1L));
        Mockito.verify(repositorioReserva, Mockito.times(1)).eliminar(Mockito.anyLong());
    }
}
