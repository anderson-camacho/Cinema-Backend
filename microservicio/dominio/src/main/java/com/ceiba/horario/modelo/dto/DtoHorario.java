package com.ceiba.horario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoHorario {

    private Long id;
    private Long idPelicula;
    private String fecha;
    private Long cupos;

}
