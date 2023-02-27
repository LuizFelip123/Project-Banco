package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.model.Cilindro;
import org.ifba.web.bd.projectbanco.service.CilindroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cilindro/")
@PreAuthorize("isAuthenticated()")
public class CilindroController {
    @Autowired 
    private CilindroService cilindroService;
    @GetMapping("Adicionar")
    public String addShowForm(Cilindro cilindro){
        return "cilindro/adicionar";
    }
    @GetMapping("Listar")
    public String listarCilindro(Model model){
       model.addAttribute("cilindros", cilindroService.getAll()) ;
        return "cilindro/lista";
    }
    @PostMapping("Salvar")
    public String saveCilindro(@Validated Cilindro cilindro){
        cilindroService.saveCilindro(cilindro);
        return "redirect:/Cilindro/Listar";
    }

}
