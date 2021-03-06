/**
 * @author Anderson Camacho Palacios
 * @Email anderson.camacho@ceiba.com.co
 */
package com.ceiba.pelicula.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pelicula {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_DIRECTOR = "Se debe ingresar el nombre del director";
    private static final String SE_DEBE_INGRESAR_EL_TITULO_DE_LA_PELICULA = "Se debe ingresar el titulo de la pelicula";


    private Long id;
    private String titulo;
    private String director;

    public Pelicula(Long id, String titulo, String director) {

        validarObligatorio(titulo, SE_DEBE_INGRESAR_EL_TITULO_DE_LA_PELICULA);
        validarObligatorio(director, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_DIRECTOR);
        this.id = id;
        this.titulo = titulo;
        this.director = director;
    }
}
