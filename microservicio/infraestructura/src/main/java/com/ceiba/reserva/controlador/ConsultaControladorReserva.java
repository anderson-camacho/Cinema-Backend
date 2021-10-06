package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListaReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador consulta Reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListaReserva manejadorListaReserva;

    public ConsultaControladorReserva(ManejadorListaReserva manejadorListaReserva) {
        this.manejadorListaReserva = manejadorListaReserva;
    }

    @GetMapping
    @ApiOperation("Lista Reservas")
    public List<DtoReserva> listar() {
        return this.manejadorListaReserva.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Consultar Reserva")
    public DtoReserva consultarReservaId(@PathVariable Long id){
        return this.manejadorListaReserva.ejecutar(id);
    }
}
