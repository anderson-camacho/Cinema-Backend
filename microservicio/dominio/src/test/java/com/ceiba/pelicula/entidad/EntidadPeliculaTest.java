package com.ceiba.pelicula.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;
import org.junit.Test;

public class EntidadPeliculaTest {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_DIRECTOR = "Se debe ingresar el nombre del director";
    private static final String SE_DEBE_INGRESAR_EL_TITULO_DE_LA_PELICULA = "Se debe ingresar el titulo de la pelicula";


    @Test
    public void validarObligatorioTituloPelicula(){
        //Arrange
        PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder().sinTitulo();

        //Act - Assert
        BasePrueba.assertThrows(()-> peliculaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TITULO_DE_LA_PELICULA);
    }
    @Test
    public void validarObligatorioDirectorPelicula(){
        //Arrange
        PeliculaTestDataBuilder peliculaTestDataBuilder = new PeliculaTestDataBuilder().sinDirector();

        //Act - Assert
        BasePrueba.assertThrows(()-> peliculaTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_DIRECTOR);
    }
}
