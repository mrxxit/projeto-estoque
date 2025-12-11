package com.guilherme.estoque.controller;

import com.guilherme.estoque.model.Produto;
import com.guilherme.estoque.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("produtos", service.listar());
        model.addAttribute("produto", new Produto());
        return "produtos";
    }

    @PostMapping
    public String salvar(Produto p){
        service.salvar(p);
        return "redirect:/produtos";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id){
        service.deletar(id);
        return "redirect:/produtos";
    }
}
