package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final FabricaReserva fabricaReserva;
    private final ServicioCrearReserva servicioCrearReserva;

    public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva) {
        this.fabricaReserva = fabricaReserva;
        this.servicioCrearReserva = servicioCrearReserva;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comando) {
        Reserva reserva = this.fabricaReserva.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }

}
