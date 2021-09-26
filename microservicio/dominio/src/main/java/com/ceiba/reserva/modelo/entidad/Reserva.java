package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {
    private static final String EL_ID_DEL_USUARIO_DEBE_SER_INGRESADO = "El id del usuario debe ser ingresado";
    private static final String EL_ID_DEL_HORARIO_DEBE_SER_INGRESADO = "El id del horario debe ser ingresado";
    private Long id;
    private Long idUsuario;
    private Long idHorario;

    public Reserva(Long id, Long idUsuario, Long idHorario) {
        validarObligatorio(idUsuario, EL_ID_DEL_USUARIO_DEBE_SER_INGRESADO);
        validarObligatorio(idHorario, EL_ID_DEL_HORARIO_DEBE_SER_INGRESADO);
        this.id = id;
        this.idUsuario = idUsuario;
        this.idHorario = idHorario;
    }
}
