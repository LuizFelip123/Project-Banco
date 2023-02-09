package org.ifba.web.bd.projectbanco.repository;

import org.springframework.stereotype.Repository;
import org.ifba.web.bd.projectbanco.model.Produto;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
    
}
