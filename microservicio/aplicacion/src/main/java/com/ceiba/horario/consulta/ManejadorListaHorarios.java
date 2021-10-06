package com.ceiba.horario.consulta;

import com.ceiba.horario.modelo.dto.DtoHorario;
import com.ceiba.horario.puerto.dao.DaoHorario;
import com.ceiba.pelicula.modelo.dto.DtoPelicula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaHorarios {
    private final DaoHorario daoHorario;

    public ManejadorListaHorarios(DaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public List<DtoHorario> ejecutar() {
        return this.daoHorario.listarHorariosConFechaSuperiorAHoy();
    }

    public DtoHorario ejecutar(Long id){return this.daoHorario.consultarHorarioId(id);}
}
