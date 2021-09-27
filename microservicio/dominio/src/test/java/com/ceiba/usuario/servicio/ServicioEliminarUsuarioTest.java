package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioEliminarUsuarioTest {

    private static final String EL_USUARIO_TIENE_UNA_RESERVA = "el usuario tiene una reserva";

    @Test
    public void validarExistenciaPeliculaEnHorarioTest() {
        //arrange
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Long idUsuario = 3L;
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existeUsuario(idUsuario)).thenReturn(true);
        ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario, repositorioReserva);

        BasePrueba.assertThrows(() -> servicioEliminarUsuario.ejecutar(idUsuario), ExcepcionExiste.class, EL_USUARIO_TIENE_UNA_RESERVA);
    }

    @Test
    public void validarPeliculaNoExistenciaPreviaTest() {
        // arrange
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Long idUsuario = 3L;
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existeUsuario(idUsuario)).thenReturn(false);
        ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario, repositorioReserva);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarUsuario.ejecutar(idUsuario));
        Mockito.verify(repositorioUsuario, Mockito.times(1)).eliminar(idUsuario);
    }
}
