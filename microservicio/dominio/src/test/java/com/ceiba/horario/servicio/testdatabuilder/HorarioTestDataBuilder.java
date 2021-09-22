package com.ceiba.horario.servicio.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.pelicula.modelo.entidad.Pelicula;

import java.time.LocalDate;

public class HorarioTestDataBuilder {
    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    public HorarioTestDataBuilder() {
        this.idPelicula = 1L;
        this.fecha = LocalDate.now();
    }

    public HorarioTestDataBuilder conCupo(Long cupos){
        this.cupos = cupos;
        return this;
    }

    public Horario build(){
        return new Horario(this.id, this.idPelicula, this.fecha, this.cupos);
    }
}
