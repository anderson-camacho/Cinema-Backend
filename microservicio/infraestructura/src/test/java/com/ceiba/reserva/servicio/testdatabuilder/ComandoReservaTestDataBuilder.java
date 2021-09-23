package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

public class ComandoReservaTestDataBuilder {
    private Long id;
    private Long idUsuario;
    private Long idHorario;

    public ComandoReservaTestDataBuilder() {
        this.id = 12L;
        this.idUsuario = 1L;
        this.idHorario = 1L;
    }

    public ComandoReservaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdHorario(Long idHorario) {
        this.idUsuario = idHorario;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(id, idUsuario, idHorario);
    }
}
