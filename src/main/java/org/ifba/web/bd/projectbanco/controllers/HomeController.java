package org.ifba.web.bd.projectbanco.controllers;

import org.ifba.web.bd.projectbanco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String profileSelect(Model model, OAuth2AuthenticationToken authentication) {
        usuarioService.setGoogleUserSecurityContext(authentication);
        
        usuarioService.verficarUsuario();

        if(usuarioService.isAdministrador()){
            usuarioService.addAdminRole(authentication);
        }
        System.out.println(usuarioService.isAdministrador());


        return "/home"; 
        
    }
} 