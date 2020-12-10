package com.mvlfernandes.repository;

import java.util.ArrayList;
import java.util.List;

import com.mvlfernandes.model.Ordem;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OrdemRepositoryTest {
    
    @InjectMock
    OrdemRepository ordemRepository;

    public void testarListAll() {
        Ordem primeiraOrdem = new Ordem();
        Ordem segundaOrdem = new Ordem();
        List<Ordem> ordens = new ArrayList<Ordem>();

        ordens.add(primeiraOrdem);
        ordens.add(segundaOrdem);

        Mockito.when(ordemRepository.listAll()).thenReturn(ordens);
        Assertions.assertSame(segundaOrdem, ordemRepository.listAll().get(1));
    }
}
