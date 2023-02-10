package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Filial;
import org.ifba.web.bd.projectbanco.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/Filial/")
@PreAuthorize("isAuthenticated()")
public class FilialController {

    @Autowired
    FilialService filialService;


    @GetMapping ("Adicionar")
    public String showAddForm(  Model model) {
        return "filial/adicionar";
    }  

    @GetMapping("Listar")
    public String listarFilial(Model model){

        return "filial/lista";
    }
    @PostMapping("Adicionar")
    public String addFilial(@Validated Filial filial, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/Filial/Adicionar";
        }

        return "redirect:/Filial/Listar";
    }
    
}
