package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinCupos;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE = "La reserva ya existe para este usuario";
    private static final String NO_HAY_CUPOS_EN_EL_HORARIO = "No hay cupos en el horario";

    private final RepositorioReserva repositorioReserva;
    private final RepositorioHorario repositorioHorario;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioHorario repositorioHorario) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioHorario = repositorioHorario;
    }

    public Long ejecutar(Reserva reserva) {
        validarUsuarioYaReservo(reserva);
        validarHayCuposEnHorario(reserva);
        seReserva(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void seReserva(Reserva reserva) {
        repositorioHorario.seReservo(reserva.getIdHorario());
    }

    private void validarUsuarioYaReservo(Reserva reserva) {
        boolean existe = this.repositorioReserva.usuarioYaReservo(reserva.getIdUsuario(), reserva.getIdHorario());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE);
        }
    }

    private void validarHayCuposEnHorario(Reserva reserva) {
        boolean disponibles = this.repositorioHorario.cuposRestantes(reserva.getIdHorario());
        if (!disponibles) {
            throw new ExcepcionSinCupos(NO_HAY_CUPOS_EN_EL_HORARIO);
        }
    }
}
