package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.*;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {
    private final ManejadorListarUsuarios manejadorListarUsuarios;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Pelicula")
    public DtoUsuario consultarUsuarioId(@PathVariable Long id){
        return this.manejadorListarUsuarios.ejecutar(id);
    }
}
