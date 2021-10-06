/**
 * @author Anderson Camacho Palacios
 * @Email anderson.camacho@ceiba.com.co
 */
package com.ceiba.pelicula.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPelicula {
    private Long id;
    private String titulo;
    private String director;
}
