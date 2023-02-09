package org.ifba.web.bd.projectbanco.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Filial/")
@PreAuthorize("isAuthenticated()")
public class FilialController {
    @GetMapping ("Adicionar")
    public String showAddForm(  Model model) {
        return "filial/adicionar";
    }  

    @GetMapping("Listar")
    public String listarFilial(){

        return "filial/lista";
    }
}
