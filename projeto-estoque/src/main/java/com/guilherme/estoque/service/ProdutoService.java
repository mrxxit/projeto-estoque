package com.guilherme.estoque.service;

import com.guilherme.estoque.model.Produto;
import com.guilherme.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> listar(){
        return repo.findAll();
    }

    public Produto salvar(Produto p){
        if (p.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido!");
        }
        return repo.save(p);
    }

    public void deletar(Long id){
        repo.deleteById(id);
    }

    public double calcularPrecoComDesconto(Produto p, double desconto){
        if(desconto < 0 || desconto > 100){
            throw new RuntimeException("Desconto inválido!");
        }
        return p.getPreco() - (p.getPreco() * (desconto / 100));
    }
}
