package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {
    private static final String LA_RESERVA_NO_EXISTE = "La reserva no existe";

    private final RepositorioReserva repositorioReserva;

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long id) {
        validarNoExistenciaPrevia(id);
        this.repositorioReserva.eliminar(id);
    }

    private void validarNoExistenciaPrevia(Long id) {
        boolean existe = this.repositorioReserva.existe(id);
        if (!existe) {
            throw new ExcepcionExiste(LA_RESERVA_NO_EXISTE);
        }
    }
}
