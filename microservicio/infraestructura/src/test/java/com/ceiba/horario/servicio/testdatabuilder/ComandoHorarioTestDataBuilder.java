package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDate;

public class ComandoHorarioTestDataBuilder {

    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    public ComandoHorarioTestDataBuilder() {
        idPelicula = 999L;
        fecha = LocalDate.now();
        cupos = 60L;
    }

    public ComandoHorario build(){
        return new ComandoHorario(id, idPelicula, fecha, cupos);
    }
}
