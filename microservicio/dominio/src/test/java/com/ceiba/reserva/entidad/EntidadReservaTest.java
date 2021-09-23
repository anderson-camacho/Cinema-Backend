package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;

public class EntidadReservaTest {
    private static final String EL_ID_DEL_USUARIO_DEBE_SER_INGRESADO = "El id del usuario debe ser ingresado";
    private static final String EL_ID_DEL_HORARIO_DEBE_SER_INGRESADO = "El id del horario debe ser ingresado";

    @Test
    public void validarReservaSinIdUsuario() {
        // Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().sinIdUsuario();

        // Act - Assert
        BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorObligatorio.class, EL_ID_DEL_USUARIO_DEBE_SER_INGRESADO);
    }

    @Test
    public void validarReservaSinIdHorario() {
// Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().sinIdHorario();

        // Act - Assert
        BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorObligatorio.class, EL_ID_DEL_HORARIO_DEBE_SER_INGRESADO);
    }
}
