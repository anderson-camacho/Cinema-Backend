package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;

import java.time.LocalDate;

public class ComandoHorarioTestDataBuilder {

    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    public ComandoHorarioTestDataBuilder() {
        idPelicula = 3L;
        fecha = LocalDate.now();
        cupos = 60L;
    }

    public ComandoHorarioTestDataBuilder conIdPelicula(Long idPelicula){
        this.idPelicula = idPelicula;
        return this;
    }

    public ComandoHorario build() {
        return new ComandoHorario(id, idPelicula, fecha, cupos);
    }
}
