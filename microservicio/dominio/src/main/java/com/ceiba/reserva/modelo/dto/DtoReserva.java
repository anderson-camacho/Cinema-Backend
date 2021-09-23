package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private Long idUsuario;
    private Long idHorario;
}
