package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Produto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("Adicionar")
    public String addFilial(@Validated Produto produto, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/Produto/Adicionar";
        }

        return "redirect:/Produto/Listar";
    }
    @GetMapping("Deletar/{id}")
    public String deleteFilial(@PathVariable("id") long id ){

        return "redirect:/Produto/Listar";
    }
}
