package com.ceiba.horario.controlador;

import com.ceiba.horario.consulta.ManejadorListaHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/horarios")
@Api(tags = {"Controlador consulta Horario"})
public class ConsultaControladorHorario {
    private final ManejadorListaHorarios manejadorListaHorarios;

    public ConsultaControladorHorario(ManejadorListaHorarios manejadorListaHorarios) {
        this.manejadorListaHorarios = manejadorListaHorarios;
    }

    @GetMapping
    @ApiOperation("Lista Horarios")
    public List<DtoHorario> listarHorariosConFechaSuperiorAHoy() {
        return this.manejadorListaHorarios.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Horario")
    public DtoHorario consultarId(@PathVariable Long id){
        return this.manejadorListaHorarios.ejecutar(id);
    }
}
