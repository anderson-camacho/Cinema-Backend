package com.ceiba.pelicula.controlador;

import com.ceiba.ApplicationMock;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorPelicula.class)
public class ConsultaControladorPeliculaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        mockMvc.perform(get("/peliculas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].titulo", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].director", IsNull.notNullValue()));
    }
}