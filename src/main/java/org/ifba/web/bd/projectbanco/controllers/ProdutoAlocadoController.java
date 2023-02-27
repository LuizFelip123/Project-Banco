package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.ProdutoAlocado;
import org.ifba.web.bd.projectbanco.service.FilialService;
import org.ifba.web.bd.projectbanco.service.ProdutoAlocadoService;
import org.ifba.web.bd.projectbanco.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/ProdutoAlocado/")
@PreAuthorize("isAuthenticated()")
public class ProdutoAlocadoController {
    @Autowired
    private ProdutoAlocadoService produtoAlocadoService;
    @Autowired
    private FilialService filialService;
    @Autowired
    private ProdutoService produtoService;
    @GetMapping("Adicionar")
    public String addShowForm(ProdutoAlocado produtoAlocado, Model model) {
        model.addAttribute("filias", filialService.getAll());
        model.addAttribute("produtos", produtoService.getAll());
        return"produtoAlocado/adicionar";
    }
    @PostMapping("Salvar")
    public String saveProdutoAlocado(@Validated ProdutoAlocado produtoAlocado){
        produtoAlocadoService.saveProdutoAlocado(produtoAlocado);
              
        return"redirect:/ProdutoAlocado/Listar";
    }
    @GetMapping("Listar")
    public String listProdutoAlocado(Model model){
        model.addAttribute("produtosAlocados",produtoAlocadoService.getAll());
        return "produtoAlocado/lista";
    }

}
