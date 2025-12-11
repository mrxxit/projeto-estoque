package com.guilherme.estoque.tests;

import com.guilherme.estoque.model.Produto;
import com.guilherme.estoque.repository.ProdutoRepository;
import com.guilherme.estoque.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    ProdutoRepository repo = Mockito.mock(ProdutoRepository.class);
    ProdutoService service = new ProdutoService(repo);

    @Test
    void testPrecoInvalido(){
        Produto p = new Produto();
        p.setPreco(0);
        Exception ex = assertThrows(RuntimeException.class, () -> service.salvar(p));
        assertEquals("Preço inválido!", ex.getMessage());
    }

    @Test
    void testCalcularDesconto(){
        Produto p = new Produto();
        p.setPreco(100);
        double preco = service.calcularPrecoComDesconto(p, 10);
        assertEquals(90, preco);
    }

    @Test
    void testListarProdutos(){
        Mockito.when(repo.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.listar().size());
    }
}
