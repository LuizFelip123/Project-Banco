package org.ifba.web.bd.projectbanco.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Cilindro/")
@PreAuthorize("isAuthenticated()")
public class CilindroController {

    @GetMapping("Adicionar")
    public String addShowForm(){
        return"";
    }
}
