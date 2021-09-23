package com.ceiba.horario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.comando.manejador.ManejadorCrearHorario;
import com.ceiba.horario.comando.manejador.ManejadorEliminarHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarios")
@Api(tags = {"Controlador comando horario"})
public class ComandoControladorHorario {
    private final ManejadorCrearHorario manejadorCrearHorario;
    private final ManejadorEliminarHorario manejadorEliminarHorario;

    @Autowired
    public ComandoControladorHorario(ManejadorCrearHorario manejadorCrearHorario, ManejadorEliminarHorario manejadorEliminarHorario) {
        this.manejadorCrearHorario = manejadorCrearHorario;
        this.manejadorEliminarHorario = manejadorEliminarHorario;
    }

    @PostMapping
    @ApiOperation("Crear Horario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHorario comandoHorario) {
        return manejadorCrearHorario.ejecutar(comandoHorario);
    }

    @DeleteMapping
    @ApiOperation("Eliminar Horario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarHorario.ejecutar(id);
    }

}
