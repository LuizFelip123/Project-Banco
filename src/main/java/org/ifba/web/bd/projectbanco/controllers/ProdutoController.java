package org.ifba.web.bd.projectbanco.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Produto/")
@PreAuthorize("isAuthenticated()")
public class ProdutoController {
    @GetMapping("Adicionar")
    public String showAddForm(Model model) {
        return "produto/adicionar";
    } 
    @GetMapping("Listar")
    public String listarProduto(Model model){
        return "produto/lista";
    }
}
