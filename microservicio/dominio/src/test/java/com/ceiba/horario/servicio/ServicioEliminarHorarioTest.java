package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarHorarioTest {

    private static final String EL_HORARIO_NO_EXISTE = "El horario no existe";

    @Test
    public void validarPeliculaExistenciaPreviaTest() {
        // arrange
//        Horario horario = new HorarioTestDataBuilder().conId(1L).build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarHorario servicioEliminarHorario = new ServicioEliminarHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarHorario.ejecutar(1L), ExcepcionExiste.class, EL_HORARIO_NO_EXISTE);
    }
}
