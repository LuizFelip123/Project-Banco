package org.ifba.web.bd.projectbanco.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/ProdutoAlocado/")
@PreAuthorize("isAuthenticated()")
public class ProdutoAlocadoController {
    
    @GetMapping("Adicionar")
    public String addShowForm() {
        return"produtoAlocado/adicionar";
    }
    

}
