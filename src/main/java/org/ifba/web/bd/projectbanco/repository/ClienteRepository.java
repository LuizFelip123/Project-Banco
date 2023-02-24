package org.ifba.web.bd.projectbanco.repository;

import org.ifba.web.bd.projectbanco.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Double> {
    
}
