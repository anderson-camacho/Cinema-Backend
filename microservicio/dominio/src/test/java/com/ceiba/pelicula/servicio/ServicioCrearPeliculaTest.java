package com.ceiba.pelicula.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPeliculaTest {

    @Test
    public void validarPeliculaExistenciaPreviaTest() {
        // arrange
        Pelicula pelicula = new PeliculaTestDataBuilder().build();
        RepositorioPelicula repositorioPelicula = Mockito.mock(RepositorioPelicula.class);
        Mockito.when(repositorioPelicula.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPelicula servicioCrearPelicula = new ServicioCrearPelicula(repositorioPelicula);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPelicula.ejecutar(pelicula), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
