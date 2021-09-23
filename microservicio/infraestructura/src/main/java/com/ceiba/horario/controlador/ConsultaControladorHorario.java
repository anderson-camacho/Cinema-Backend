package com.ceiba.horario.controlador;

import com.ceiba.horario.consulta.ManejadorListaHorarios;
import com.ceiba.horario.modelo.dto.DtoHorario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<DtoHorario> listar() {
        return this.manejadorListaHorarios.ejecutar();
    }
}
