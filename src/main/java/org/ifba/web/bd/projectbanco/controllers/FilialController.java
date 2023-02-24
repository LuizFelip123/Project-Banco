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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/Filial/")
@PreAuthorize("isAuthenticated()")
public class FilialController {

    @Autowired
    private FilialService filialService;


    @GetMapping ("Adicionar")
    public String showAddForm(Filial filial,  Model model) {
        return "filial/adicionar";
    }  

    @GetMapping("Listar")
    public String listarFilial(Model model){
        model.addAttribute("filias", filialService.getAll());
        return "filial/lista";
    }
    @PostMapping("Salvar")
    public String addFilial(@Validated Filial filial, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/Filial/Adicionar";
        }
        filialService.saveFilial(filial);

        return "redirect:/Filial/Listar";
    }
    @GetMapping("Deletar/{id}")
    public String deleteFilial(@PathVariable("id") long id ){

        return "redirect:/Filial/Listar";
    }

    @GetMapping("Editar/{id}")
    public String editarFilial(@PathVariable("id") long id, Model model, Filial filial){
    System.out.println(filialService.findFilial(id).get().getCidade());
       model.addAttribute("filialOld", filialService.findFilial(id).get()); 
        return "filial/editar";
    }

    @PostMapping("Editada/{id}")
     public String saveEditar(@PathVariable("id") long id, @Validated Filial filial){
        
        filialService.editarFilial(id, filial);
        return"redirect:/Filial/Listar";
     }           
    
    
    
}
