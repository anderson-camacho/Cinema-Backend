package com.ceiba.pelicula.controlador;

import com.ceiba.pelicula.consulta.ManejadorListaPeliculas;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import com.ceiba.usuario.controlador.ConsultaControladorUsuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ConsultaControladorPelicula {
    private final ManejadorListaPeliculas manejadorListaPeliculas;

    public ConsultaControladorPelicula(ManejadorListaPeliculas manejadorListaPeliculas){
        this.manejadorListaPeliculas = manejadorListaPeliculas;
    }

    @GetMapping
    @ApiOperation("Lista Peliculas")
    public List<DtoPelicula> listar(){
        return this.manejadorListaPeliculas.ejecutar();
    }

}
