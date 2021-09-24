package com.ceiba.dominio.excepcion;

public class ExcepcionSinCupos extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionSinCupos(String mensaje) {
        super(mensaje);
    }
}
