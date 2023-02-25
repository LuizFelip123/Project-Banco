package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Cliente;
import org.ifba.web.bd.projectbanco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cliente/")
@PreAuthorize("isAuthenticated()")
public class ClienteController {
    @Autowired 
    private ClienteService clienteService;
    @GetMapping("Adicionar")
    public String showAddForm(Cliente cliente) {
        
        return "cliente/adicionar";
    }
    @PostMapping("Salvar")
    public String saveCliente(@Validated Cliente cliente){  
        clienteService.saveCliente(cliente);
        return "redirect:/Cliente/Listar";
    }
    @GetMapping("Listar")
    public String listarCliente(Model model){
        model.addAttribute("clientes", clienteService.getAll());
        return "cliente/lista";
    }
    @GetMapping("Editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model, Cliente cliente){
       Cliente clienteOld = clienteService.getCliente(id);
        model.addAttribute("clienteOld", clienteOld);
        return "cliente/editar";    
    }
    @PostMapping("Editada/{id}")
    public String salvarEditadoCliente(@PathVariable("id") Long id, @Validated Cliente cliente){
        clienteService.editarCliente(id, cliente);
        return "redirect:/Cliente/Listar";
    }
    @GetMapping("Deletar/{id}")
    public String deletarCliente(@PathVariable("id") Long id){
        clienteService.deleteCliente(id);
        return "redirect:/Cliente/Listar";
    }
}
