package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador comando reserva"})
public class ComandoControladorReserva {
    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorEliminarReserva manejadorEliminarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorEliminarReserva manejadorEliminarReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
    }

    @PostMapping
    @ApiOperation("Crear Reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Reserva")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarReserva.ejecutar(id);
    }
}
