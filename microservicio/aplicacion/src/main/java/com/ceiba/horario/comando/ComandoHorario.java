package com.ceiba.horario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHorario {
    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;
}
