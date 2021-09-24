package com.ceiba.pelicula.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.comando.fabrica.FabricaPelicula;
import com.ceiba.pelicula.modelo.entidad.Pelicula;
import com.ceiba.pelicula.servicio.ServicioActualizarPelicula;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPelicula implements ManejadorComando<ComandoPelicula> {


    private final FabricaPelicula fabricaPelicula;
    private final ServicioActualizarPelicula servicioActualizarPelicula;

    public ManejadorActualizarPelicula(FabricaPelicula fabricaPelicula, ServicioActualizarPelicula servicioActualizarPelicula) {
        this.fabricaPelicula = fabricaPelicula;
        this.servicioActualizarPelicula = servicioActualizarPelicula;
    }

    public void ejecutar(ComandoPelicula comandoPelicula) {
        Pelicula pelicula = this.fabricaPelicula.crear(comandoPelicula);
        this.servicioActualizarPelicula.ejecutar(pelicula);
    }
}
