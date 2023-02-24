package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Cliente;
import org.ifba.web.bd.projectbanco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cliente/")
@PreAuthorize("isAuthenticated()")
public class ClienteController {
    @Autowired 
    private ClienteService clienteService;
    @GetMapping("Adicionar")
    public String showAddForm(  Model model) {
        return "cliente/adicionar";
    }
    @PostMapping("Salvar")
    public String saveCliente(@Validated Cliente cliente){  
        clienteService.saveCliente(cliente);
        return "redirect:/Cliente/Listar";
    }
    @GetMapping("Listar")
    public String listarProdutos(Model model){
        return "cliente/lista";
    }

}
