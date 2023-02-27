package org.ifba.web.bd.projectbanco.service;

import java.util.List;

import org.ifba.web.bd.projectbanco.model.Cilindro;
import org.ifba.web.bd.projectbanco.repository.CilindroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CilindroService {
    @Autowired
    private CilindroRepository cilindroRepository;
    
    public List<Cilindro> getAll(){
        return (List<Cilindro>)cilindroRepository.findAll();
    }
    public void saveCilindro(Cilindro cilindro){
        cilindroRepository.save(cilindro);
    }
}
