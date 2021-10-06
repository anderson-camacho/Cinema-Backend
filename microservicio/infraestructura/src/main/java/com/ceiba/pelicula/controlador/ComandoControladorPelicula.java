package com.ceiba.pelicula.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.comando.manejador.ManejadorActualizarPelicula;
import com.ceiba.pelicula.comando.manejador.ManejadorCrearPelicula;
import com.ceiba.pelicula.comando.manejador.ManejadorEliminarPelicula;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/peliculas")
@Api(tags = {"Controlador comando pelicula"})
public class ComandoControladorPelicula {
    private final ManejadorCrearPelicula manejadorCrearPelicula;
    private final ManejadorEliminarPelicula manejadorEliminarPelicula;
    private final ManejadorActualizarPelicula manejadorActualizarPelicula;

    static Logger log = Logger.getLogger(ComandoControladorPelicula.class.getName());

    @Autowired
    public ComandoControladorPelicula(ManejadorCrearPelicula manejadorCrearPelicula,
                                     ManejadorEliminarPelicula manejadorEliminarPelicula,
                                     ManejadorActualizarPelicula manejadorActualizarPelicula){
        this.manejadorCrearPelicula = manejadorCrearPelicula;
        this.manejadorEliminarPelicula = manejadorEliminarPelicula;
        this.manejadorActualizarPelicula = manejadorActualizarPelicula;
    }

    @PostMapping
    @ApiOperation("Crear Pelicula")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPelicula comandoPelicula) {
        return manejadorCrearPelicula.ejecutar(comandoPelicula);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar pelicula")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPelicula.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar pelicula")
    public void actualizar(@RequestBody ComandoPelicula comandoPelicula,@PathVariable Long id) {
        comandoPelicula.setId(id);
        manejadorActualizarPelicula.ejecutar(comandoPelicula);
    }
}
