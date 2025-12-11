package com.guilherme.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guilherme.estoque.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
