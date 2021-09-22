package com.ceiba.configuracion;

import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.ServicioActualizarPelicula;
import com.ceiba.pelicula.servicio.ServicioCrearPelicula;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class BeanServicio {

    /**
     * Beans del Pelicula
     */

    @Bean
    public ServicioCrearPelicula servicioCrearPelicula(RepositorioPelicula repositorioPelicula){
        return new ServicioCrearPelicula(repositorioPelicula);
    }

    @Bean
    ServicioEliminarPelicula servicioEliminarPelicula(RepositorioPelicula repositorioPelicula){
        return new ServicioEliminarPelicula(repositorioPelicula);
    }

    @Bean
    ServicioActualizarPelicula servicioActualizarPelicula(RepositorioPelicula repositorioPelicula){
        return new ServicioActualizarPelicula(repositorioPelicula);
    }

    /**
     * Beans del Usuario
     */
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	

}
