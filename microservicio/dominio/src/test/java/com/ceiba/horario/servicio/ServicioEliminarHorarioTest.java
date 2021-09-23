package com.ceiba.horario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarHorarioTest {

    private static final String EL_HORARIO_NO_EXISTE = "El horario no existe";

    @Test
    public void validarPeliculaExistenciaPreviaTest() {
        // arrange
        Horario horario = new HorarioTestDataBuilder().conId(5L).build();
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarHorario servicioEliminarHorario = new ServicioEliminarHorario(repositorioHorario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarHorario.ejecutar(1L), ExcepcionExiste.class, EL_HORARIO_NO_EXISTE);
    }
}
