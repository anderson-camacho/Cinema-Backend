package com.ceiba.dominio.excepcion;

public class ExcepcionUsuarioNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioNoExiste(String mensaje) {
        super(mensaje);
    }
}
