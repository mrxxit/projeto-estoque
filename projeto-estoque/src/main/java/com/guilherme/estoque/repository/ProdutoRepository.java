package com.guilherme.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.guilherme.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
