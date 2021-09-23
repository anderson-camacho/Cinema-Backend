package com.ceiba.pelicula.comando.manejador;

import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPelicula {
    private final ServicioEliminarPelicula servicioEliminarPelicula;

    public ManejadorEliminarPelicula(ServicioEliminarPelicula servicioEliminarPelicula) {
        this.servicioEliminarPelicula = servicioEliminarPelicula;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarPelicula.ejecutar(id);
    }
}
