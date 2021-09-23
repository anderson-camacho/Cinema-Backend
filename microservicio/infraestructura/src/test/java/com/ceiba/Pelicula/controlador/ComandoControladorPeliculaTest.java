package com.ceiba.Pelicula.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.Pelicula.servicio.ComandoPeliculaTestDataBuilder;
import com.ceiba.pelicula.comando.ComandoPelicula;
import com.ceiba.pelicula.controlador.ComandoControladorPelicula;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPelicula.class)
public class ComandoControladorPeliculaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception{
        ComandoPelicula pelicula = new ComandoPeliculaTestDataBuilder().build();

        mockMvc.perform(post("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 5}"));

    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoPelicula pelicula = new ComandoPeliculaTestDataBuilder().build();

        // act - assert
        mockMvc.perform(put("/peliculas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk());
    }


    @Test
    public void eliminar() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/peliculas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


