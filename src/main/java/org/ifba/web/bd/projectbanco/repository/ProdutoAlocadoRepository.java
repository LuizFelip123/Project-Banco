package org.ifba.web.bd.projectbanco.repository;

import org.ifba.web.bd.projectbanco.model.ProdutoAlocado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoAlocadoRepository extends CrudRepository<ProdutoAlocado, Long> {
    
}
