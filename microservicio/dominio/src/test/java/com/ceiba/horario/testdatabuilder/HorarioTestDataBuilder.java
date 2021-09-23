package com.ceiba.horario.testdatabuilder;

import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.pelicula.testdatabuilder.PeliculaTestDataBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HorarioTestDataBuilder {
    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    private static final Long MAYOR_A_CERO = 0L;

    public HorarioTestDataBuilder() {
        this.idPelicula = 1L;
        this.fecha = LocalDate.now();
        this.cupos = 60L;
    }
    public HorarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public HorarioTestDataBuilder conCupo(Long cupos){
        this.cupos = cupos;
        return this;
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

    private LocalDate formatearFechaStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }

    private String formatearFechaLocalDateAString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        return formatter.format(date);
    }
}
