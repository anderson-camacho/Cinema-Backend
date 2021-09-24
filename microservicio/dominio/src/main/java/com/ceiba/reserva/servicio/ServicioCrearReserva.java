package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE = "La reserva ya existe para este usuario";

    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva) {
        validarUsuarioYaReservo(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarUsuarioYaReservo(Reserva reserva) {
        boolean existe = this.repositorioReserva.usuarioYaReservo(reserva.getIdUsuario(), reserva.getIdHorario());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE);
        }
    }
}
