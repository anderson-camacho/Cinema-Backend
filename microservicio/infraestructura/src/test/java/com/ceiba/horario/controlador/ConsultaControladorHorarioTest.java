package com.ceiba.horario.controlador;

import com.ceiba.ApplicationMock;
import org.hamcrest.collection.IsEmptyCollection;
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
@WebMvcTest(ConsultaControladorHorario.class)
public class ConsultaControladorHorarioTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listarHorariosConFechaSuperiorAHoy() throws Exception {
        mockMvc.perform(get("/horarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void consultarHorarioId() throws Exception {
        mockMvc.perform(get("/horarios/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", IsNull.notNullValue()))
                .andExpect(jsonPath("$.idPelicula", IsNull.notNullValue()))
                .andExpect(jsonPath("$.fecha", IsNull.notNullValue()))
                .andExpect(jsonPath("$.cupos", IsNull.notNullValue()));
    }
}
