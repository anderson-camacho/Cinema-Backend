package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPeliculaTest {
    private static final String LA_PELICULA_NO_EXISTE = "La pelicula no existe";

    @Test
    public void validarPeliculaExistenciaPreviaTest() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(9L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPelicula servicioEliminarPelicula = new ServicioEliminarPelicula(repositorioPelicula);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPelicula.ejecutar(1L), ExcepcionExiste.class, LA_PELICULA_NO_EXISTE);
    }
}
