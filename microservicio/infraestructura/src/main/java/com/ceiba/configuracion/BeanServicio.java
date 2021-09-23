package com.ceiba.configuracion;

import com.ceiba.horario.puerto.repositorio.RepositorioHorario;
import com.ceiba.horario.servicio.ServicioCrearHorario;
import com.ceiba.horario.servicio.ServicioEliminarHorario;
import com.ceiba.pelicula.puerto.repositorio.RepositorioPelicula;
import com.ceiba.pelicula.servicio.ServicioActualizarPelicula;
import com.ceiba.pelicula.servicio.ServicioCrearPelicula;
import com.ceiba.pelicula.servicio.ServicioEliminarPelicula;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    /**
     * Beans del Horario
     */

    @Bean
    public ServicioCrearHorario servicioCrearHorario(RepositorioHorario repositorioHorario) {
        return new ServicioCrearHorario(repositorioHorario);
    }

    @Bean
    ServicioEliminarHorario servicioEliminarHorario(RepositorioHorario repositorioHorario) {
        return new ServicioEliminarHorario(repositorioHorario);
    }

    /**
     * Beans del Pelicula
     */

    @Bean
    public ServicioCrearPelicula servicioCrearPelicula(RepositorioPelicula repositorioPelicula) {
        return new ServicioCrearPelicula(repositorioPelicula);
    }

    @Bean
    ServicioEliminarPelicula servicioEliminarPelicula(RepositorioPelicula repositorioPelicula) {
        return new ServicioEliminarPelicula(repositorioPelicula);
    }

    @Bean
    ServicioActualizarPelicula servicioActualizarPelicula(RepositorioPelicula repositorioPelicula) {
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
