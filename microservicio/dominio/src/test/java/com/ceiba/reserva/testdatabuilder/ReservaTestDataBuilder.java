package com.ceiba.reserva.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

public class ReservaTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idHorario;

    public ReservaTestDataBuilder() {
        this.id = 1L;
        this.idUsuario = 1L;
        this.idHorario = 1L;
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder sinIdUsuario() {
        this.idUsuario = null;
        return this;
    }

    public ReservaTestDataBuilder sinIdHorario() {
        this.idHorario = null;
        return this;
    }

    public Reserva build() {
        return new Reserva(this.id, this.idUsuario, this.idHorario);
    }

}
