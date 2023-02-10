package org.ifba.web.bd.projectbanco.service;

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
}
