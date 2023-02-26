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
    public Produto findProduto(Long id){
        return produtoRepository.findById(id).get();
    }
    public void editarFilial(Long id, Produto produto){
      Produto produto2 = findProduto(id);
      if(produto.getMarca().isEmpty()){
        produto.setMarca(produto2.getMarca());
      }
      if(produto.getDescricao().isEmpty())
         produto.setDescricao(produto2.getDescricao());
      if(produto.getNome().isEmpty())
         produto.setNome(produto2.getNome());
      if(produto.getMarca().isEmpty())
         produto.setMarca(produto2.getMarca());
      if(produto.getValor()== null) 
        produto.setValor(produto2.getValor());
       if(produto.getQuantidade() == 0)
        produto.setQuantidade(produto2.getQuantidade());
      produto.setId(id);
      produtoRepository.save(produto); 
    }
}
