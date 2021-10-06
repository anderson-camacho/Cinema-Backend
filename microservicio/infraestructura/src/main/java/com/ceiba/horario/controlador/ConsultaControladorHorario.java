package com.ceiba.horario.controlador;

import com.ceiba.horario.consulta.ManejadorListaHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
