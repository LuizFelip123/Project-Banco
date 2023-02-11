package org.ifba.web.bd.projectbanco.service;

import java.util.List;

import org.ifba.web.bd.projectbanco.model.Produto;
import org.ifba.web.bd.projectbanco.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public void saveProduto(Produto produto){   
        produtoRepository.save(produto);
    }
    public List<Produto> getAll(){
        return (List<Produto>) produtoRepository.findAll();
    }
    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
