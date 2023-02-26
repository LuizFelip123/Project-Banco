package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Produto;
import org.ifba.web.bd.projectbanco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("Adicionar")
    public String showAddForm(Model model, Produto produto) {
        return "produto/adicionar";
    }

    @GetMapping("Listar")
    public String listarProduto(Model model){
        model.addAttribute("produtos",produtoService.getAll());
            return "produto/lista";
    }

    @PostMapping("Salvar")
    public String addProduto(@Validated Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/Produto/Adicionar";
        }
        produtoService.saveProduto(produto);
        return "redirect:/Produto/Listar";
    }

    @GetMapping("Deletar/{id}")
    public String deleteProduto(@PathVariable("id") Long id) {
        produtoService.deleteProduto(id);
        return "redirect:/Produto/Listar";
    }
    @GetMapping("Editar/{id}")
    public String editarProduto(@PathVariable("id") Long id, Model model, Produto produto){
       model.addAttribute("produtoOld", produtoService.findProduto(id)); 
        return "produto/editar";
    }
    @PostMapping("Editada/{id}")
    public String saveEditar(@PathVariable("id") Long id, @Validated Produto produto,  BindingResult result){
       
       produtoService.editarFilial(id, produto);
       return"redirect:/Produto/Listar";
    }     
}
