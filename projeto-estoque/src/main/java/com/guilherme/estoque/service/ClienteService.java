package com.guilherme.estoque.service;

import com.guilherme.estoque.model.Cliente;
import com.guilherme.estoque.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente salvar(Cliente c) {
        if (c.getNome() == null || c.getNome().trim().isEmpty()) {
            throw new RuntimeException("Nome inválido!");
        }
        return repo.save(c);
    }

    public void deletar(Long id){
        repo.deleteById(id);
    }
}
