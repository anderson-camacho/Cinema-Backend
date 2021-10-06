package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaReserva {
    private final DaoReserva daoReserva;

    public ManejadorListaReserva(DaoReserva reserva) {

        this.daoReserva = reserva;
    }

    public List<DtoReserva> ejecutar() {
        return this.daoReserva.listarReserva();
    }

    public DtoReserva ejecutar(Long id){return this.daoReserva.consultarReservaId(id);}
}
