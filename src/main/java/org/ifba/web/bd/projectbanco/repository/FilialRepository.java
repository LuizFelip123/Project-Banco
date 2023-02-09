package org.ifba.web.bd.projectbanco.repository;

import org.ifba.web.bd.projectbanco.model.Filial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository  extends CrudRepository<Filial, Long>{
    
}
