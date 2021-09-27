package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioActualizarPeliculaTest {

    private static final String LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA = "La pelicula ya existe en el sistema";

    @Test
    public void validarPeliculaExistenciaPreviaTest() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(1L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarPelicula servicioActualizarPelicula = new ServicioActualizarPelicula(repositorioPelicula);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPelicula.ejecutar(pelicula), ExcepcionDuplicidad.class, LA_PELICULA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarPeliculaNoExistenciaPreviaTest() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().conId(35L).build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(false);
        ServicioActualizarPelicula servicioActualizarPelicula = new ServicioActualizarPelicula(repositorioPelicula);
        // act - assert
        Assertions.assertDoesNotThrow(()->servicioActualizarPelicula.ejecutar(pelicula));
        Mockito.verify(repositorioPelicula, Mockito.times(1)).actualizar(pelicula);
    }
}
