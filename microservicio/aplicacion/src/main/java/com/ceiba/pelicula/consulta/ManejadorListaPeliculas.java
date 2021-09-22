package com.ceiba.pelicula.consulta;

import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.pelicula.puerto.dao.DaoPelicula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaPeliculas {
    private final DaoPelicula daoPelicula;

    public ManejadorListaPeliculas(DaoPelicula daoPelicula) {
        this.daoPelicula = daoPelicula;
    }

    public List<DtoPelicula> ejecutar() {
        return this.daoPelicula.listar();
    }
}
