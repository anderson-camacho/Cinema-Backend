package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;
import java.time.LocalDate;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDate fecha;

    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        clave = "1234";
        fecha = LocalDate.now();
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre,fecha);
    }
}
