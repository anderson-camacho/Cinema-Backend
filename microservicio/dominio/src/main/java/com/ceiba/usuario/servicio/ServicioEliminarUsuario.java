package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionExiste;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private static final String EL_USUARIO_TIENE_UNA_RESERVA = "el usuario tiene una reserva";

    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioReserva repositorioReserva;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario, RepositorioReserva repositorioReserva) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long id) {
        validarUsuarioTieneReserva(id);
        this.repositorioUsuario.eliminar(id);
    }

    private void validarUsuarioTieneReserva(Long id) {
        boolean existe = this.repositorioReserva.existeUsuario(id);
        if (existe) {
            throw new ExcepcionExiste(EL_USUARIO_TIENE_UNA_RESERVA);
        }
    }
}
