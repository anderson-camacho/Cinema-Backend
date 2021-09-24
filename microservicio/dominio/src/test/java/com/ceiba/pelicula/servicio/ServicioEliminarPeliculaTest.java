package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPeliculaTest {

    private static final String LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS = "La pelicula esta agendada en los horarios";

    @Test
    public void validarExistenciaPeliculaEnHorarioTest() {
        //arrange
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Long idPelicula = 3L;
        RepositorioHorario repositorioHorario = Mockito.mock(RepositorioHorario.class);
        Mockito.when(repositorioHorario.existePelicula(idPelicula)).thenReturn(true);
        ServicioEliminarPelicula servicioEliminarPelicula = new ServicioEliminarPelicula(repositorioPelicula, repositorioHorario);

        BasePrueba.assertThrows(() -> servicioEliminarPelicula.ejecutar(idPelicula), ExcepcionExiste.class, LA_PELICULA_ESTA_AGENDADA_EN_LOS_HORARIOS);
    }


}
