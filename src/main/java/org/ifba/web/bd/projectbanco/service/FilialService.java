package org.ifba.web.bd.projectbanco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ifba.web.bd.projectbanco.model.Filial;
import org.ifba.web.bd.projectbanco.model.ProdutoAlocado;
import org.ifba.web.bd.projectbanco.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository; 
    
    public void saveFilial(Filial filial){
        if(filialRepository.existsById(filial.getId()))
            filial.setProdutosAlocados(new ArrayList<ProdutoAlocado>());    
        
            filialRepository.save(filial);

    }  

    public List<Filial> getAll(){
        return (List<Filial>) filialRepository.findAll();
    }

    public void deleteFilial(Long id){
        
       if(id != null)
            filialRepository.deleteById(id);  
    }
    public Optional<Filial> findFilial( Long id ){
        if(id == null){
            new RuntimeException("ID é inválido!");
        } 
       Optional<Filial> filial = filialRepository.findById(id);
       
     return filial; 
    }

    public void editarFilial(Long id, Filial filial){
        filial.setId(id);
        filialRepository.save(filial);
    }
    
    

      
}
