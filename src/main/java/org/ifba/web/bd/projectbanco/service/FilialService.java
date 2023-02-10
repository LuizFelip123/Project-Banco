package org.ifba.web.bd.projectbanco.service;

import java.util.List;

import org.ifba.web.bd.projectbanco.model.Filial;
import org.ifba.web.bd.projectbanco.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {
    @Autowired
    private FilialRepository filialRepository; 
    
    public void saveFilial(Filial filial){

        filialRepository.save(filial);

    }  

    public List<Filial> getAll(){
        return (List<Filial>) filialRepository.findAll();
    }

    public void deleteFilial(Long id){
        
       if(id != null)
            filialRepository.deleteById(id);  
    }
    

      
}
