/**
 * @author Anderson Camacho
 */
package com.ceiba.horario.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Horario {
    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_EL_OBJETO_PELICULA = "Se debe ingresar el onjeto pelicula";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_MAYOR_A_HOY = "Se debe ingresar ela fecha mayor a hoy";
    private static final String SE_DEBE_INGRESAR_LOS_CUPOS = "Se debe ingresar los cupos";
    private static final String LOS_CUPOS_DEBEN_SER_MAYOR_A_0 = "lOS CUPOS DEBEN SER MAYOR A 0";

    private static final Long MAYOR_A_CERO = 0L;

    private Long id;
    private Long idPelicula;
    private LocalDate fecha;
    private Long cupos;

    public Horario(Long id, Long idPelicula, LocalDate fecha, Long cupos) {
        validarObligatorio(fecha, SE_DEBE_INGRESAR_UNA_FECHA);
        validarFecha(fecha, SE_DEBE_INGRESAR_LA_FECHA_MAYOR_A_HOY);
        validarObligatorio(idPelicula, SE_DEBE_INGRESAR_EL_OBJETO_PELICULA);
        validarObligatorio(cupos, SE_DEBE_INGRESAR_LOS_CUPOS);
        validarMenor(MAYOR_A_CERO, cupos, LOS_CUPOS_DEBEN_SER_MAYOR_A_0);
        this.cupos = cupos;
        this.fecha = fecha;
        this.idPelicula = idPelicula;
        this.id = id;

    }

}
