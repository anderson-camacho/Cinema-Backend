package com.ceiba.pelicula.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPelicula {
    private Long id;
    private String titulo;
    private String director;
}
