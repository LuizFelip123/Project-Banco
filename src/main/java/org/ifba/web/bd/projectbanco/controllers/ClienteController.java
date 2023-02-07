package org.ifba.web.bd.projectbanco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cliente/")
public class ClienteController {
    @GetMapping("Adicionar")
    public String showAddForm(  Model model) {
        return "cliente/adicionar";
    }
    @GetMapping("Listar")
    public String listarProdutos(Model model){
        return "cliente/lista";
    }

}
