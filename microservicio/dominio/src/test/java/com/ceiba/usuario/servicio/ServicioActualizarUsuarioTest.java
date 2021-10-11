package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionUsuarioNoExiste;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarUsuarioTest {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionUsuarioNoExiste.class, EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
    }

}
