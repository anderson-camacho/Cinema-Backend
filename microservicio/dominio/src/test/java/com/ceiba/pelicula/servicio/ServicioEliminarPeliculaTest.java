package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.testdatabuilder.HorarioTestDataBuilder;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPeliculaTest {
/**
    private static final String LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS = "La pelicula esta agendada en los horarios";

    @Test
    public void validarExistenciaPeliculaEnHorarioTest() {
        //arrange
//        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
//        Horario horario = new HorarioTestDataBuilder().conIdPelicula(pelicula.getId()).build();
        Mockito.when(repositorioPelicula.existe(Mockito.anyLong())).thenReturn(false);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPelicula servicioEliminarPelicula = new ServicioEliminarPelicula(repositorioPelicula, repositorioHorario);
        BasePrueba.assertThrows(() -> servicioEliminarPelicula.ejecutar(/*horario.getIdPelicula()*//**3L), ExcepcionExiste.class, LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS);
    }

    @Test
    public void validarExistenciaPeliculaEnHorarioTest2() {
        //arrange
//        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
//        Horario horario = new HorarioTestDataBuilder().conIdPelicula(pelicula.getId()).build();
        Mockito.when(repositorioPelicula.existe(Mockito.anyLong())).thenReturn(false);
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPelicula servicioEliminarPelicula = new ServicioEliminarPelicula(repositorioPelicula, repositorioHorario);
        BasePrueba.assertThrows(() -> servicioEliminarPelicula.ejecutar(/*horario.getIdPelicula()*//*7L), ExcepcionExiste.class, LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS);
    }
*/

}
