package com.ceiba.dominio.excepcion;

public class ExcepcionExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionExiste(String mensaje) {
        super(mensaje);
    }
}
