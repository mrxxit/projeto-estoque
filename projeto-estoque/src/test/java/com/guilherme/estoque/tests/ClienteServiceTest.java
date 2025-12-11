package com.guilherme.estoque.tests;

import com.guilherme.estoque.model.Cliente;
import com.guilherme.estoque.service.ClienteService;
import com.guilherme.estoque.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    ClienteRepository repo = Mockito.mock(ClienteRepository.class);
    ClienteService service = new ClienteService(repo);

    @Test
    void testCadastrarClienteInvalido(){
        Cliente c = new Cliente();
        c.setNome("");
        Exception ex = assertThrows(RuntimeException.class, () -> service.salvar(c));
        assertEquals("Nome inválido!", ex.getMessage());
    }

    @Test
    void testListarClientes(){
        Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.listar().size());
    }
}
