package org.ifba.web.bd.projectbanco.service;

import java.util.List;

import org.ifba.web.bd.projectbanco.model.ProdutoAlocado;
import org.ifba.web.bd.projectbanco.repository.ProdutoAlocadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlocadoService {
    @Autowired
    private ProdutoAlocadoRepository produtoAlocadoRepository;

    public void saveProdutoAlocado(ProdutoAlocado produtoAlocado){
        if(produtoAlocado != null)
          produtoAlocadoRepository.save(produtoAlocado);  
    }
    public List<ProdutoAlocado> getAll(){
        return (List<ProdutoAlocado>) produtoAlocadoRepository.findAll();
    }
}
