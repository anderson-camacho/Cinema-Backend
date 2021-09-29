package com.ceiba.usuario.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDate;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private LocalDate fecha;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        fecha = LocalDate.now();
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario,fecha);
    }
}
