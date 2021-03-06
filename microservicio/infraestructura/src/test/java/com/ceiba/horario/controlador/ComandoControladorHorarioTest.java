package com.ceiba.horario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.horario.comando.ComandoHorario;
import com.ceiba.horario.servicio.testdatabuilder.ComandoHorarioTestDataBuilder;
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
@WebMvcTest(ComandoControladorHorarioTest.class)
public class ComandoControladorHorarioTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception{
        ComandoHorario comandoHorario = new ComandoHorarioTestDataBuilder().conIdPelicula(1L).build();

        mockMvc.perform(post("/horarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoHorario)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':10}"));
    }

    @Test
    public void eliminarCorrecto() throws Exception{
        Long id = 9L;
        mockMvc.perform(delete("/horarios/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void eliminarIncorrecto() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/horarios/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }

}
