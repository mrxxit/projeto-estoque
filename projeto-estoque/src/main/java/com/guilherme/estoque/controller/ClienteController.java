package com.guilherme.estoque.controller;

import com.guilherme.estoque.model.Cliente;
import com.guilherme.estoque.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("clientes", service.listar());
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    @PostMapping
    public String salvar(Cliente c){
        service.salvar(c);
        return "redirect:/clientes";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id){
        service.deletar(id);
        return "redirect:/clientes";
    }
}
