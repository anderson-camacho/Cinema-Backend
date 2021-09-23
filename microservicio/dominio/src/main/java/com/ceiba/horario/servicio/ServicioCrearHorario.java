package com.ceiba.horario.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horario.modelo.entidad.Horario;
import com.ceiba.horario.puerto.repositorio.RepositorioHorario;

public class ServicioCrearHorario {

    private static final String EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA = "El horario ya existe en el sistema";

    private final RepositorioHorario repositorioHorario;

    public ServicioCrearHorario(RepositorioHorario repositorioHorario) {

        this.repositorioHorario = repositorioHorario;
    }

    public Long ejecutar(Horario horario){
        validarExistenciaPrevia(horario);
        return this.repositorioHorario.crear(horario);
    }

    private void validarExistenciaPrevia(Horario horario) {
        boolean existe = this.repositorioHorario.existe(horario.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }





}
