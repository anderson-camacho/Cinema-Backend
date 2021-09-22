package com.ceiba.horario.modelo.dto;

import com.ceiba.pelicula.modelo.entidad.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoHorario {

    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

}
