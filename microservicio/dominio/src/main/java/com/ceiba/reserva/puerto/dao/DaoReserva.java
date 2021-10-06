package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {
    List<DtoReserva> listarReserva();
    DtoReserva consultarReservaId(Long id);
}
