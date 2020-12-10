package com.mvlfernandes.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {
    
    @Test
    public void testarFindByIdOptional() {
        PanacheMock.mock(Usuario.class);

        Usuario u = new Usuario();
        Optional<PanacheEntityBase> usuario = Optional.of(u);

        Mockito.when(Usuario.findByIdOptional(3)).thenReturn(usuario);

        Assertions.assertSame(u, Usuario.findByIdOptional(3).get());
    }

}
