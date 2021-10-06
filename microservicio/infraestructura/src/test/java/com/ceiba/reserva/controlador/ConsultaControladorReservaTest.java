package com.ceiba.reserva.controlador;

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
@WebMvcTest(ConsultaControladorReserva.class)
public class ConsultaControladorReservaTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        mockMvc.perform(get("/reservas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].idUsuario", IsNull.notNullValue()))
                .andExpect(jsonPath("$[0].idHorario", IsNull.notNullValue()));
    }

    @Test
    public void consultarReservaId() throws Exception {
        mockMvc.perform(get("/reservas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", IsNull.notNullValue()))
                .andExpect(jsonPath("$.idUsuario", IsNull.notNullValue()))
                .andExpect(jsonPath("$.idHorario", IsNull.notNullValue()));
    }

}
