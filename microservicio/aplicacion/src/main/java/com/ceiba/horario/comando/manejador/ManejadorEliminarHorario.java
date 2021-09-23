package com.ceiba.horario.comando.manejador;

import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarHorario {
    private final ServicioEliminarHorario servicioEliminarHorario;

    public ManejadorEliminarHorario(ServicioEliminarHorario servicioEliminarHorario) {
        this.servicioEliminarHorario = servicioEliminarHorario;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarHorario.ejecutar(id);
    }
}
