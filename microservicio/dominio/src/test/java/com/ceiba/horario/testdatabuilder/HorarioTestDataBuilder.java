package com.ceiba.horario.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;

import java.time.LocalDate;

public class HorarioTestDataBuilder {
    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    public HorarioTestDataBuilder() {
        this.idPelicula = 1L;
        this.fecha = LocalDate.now();
        this.cupos = 60L;
    }

    public HorarioTestDataBuilder sinIdPelicula(){
        this.idPelicula = null;
        return this;
    }
    public HorarioTestDataBuilder sinCupos(){
        this.cupos = null;
        return this;
    }

    public HorarioTestDataBuilder cuposMenorCero(){
        this.cupos = -1L;
        return this;
    }

    public HorarioTestDataBuilder sinFecha(){
        this.fecha = null;
        return this;
    }

    public HorarioTestDataBuilder fechaAnteriorAHoy(){
        this.fecha = LocalDate.now().minusDays(1L);
        return this;
    }

    public Horario build(){
        return new Horario(this.id, this.idPelicula, this.fecha, this.cupos);
    }

}
