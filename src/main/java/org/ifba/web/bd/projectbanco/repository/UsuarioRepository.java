package org.ifba.web.bd.projectbanco.repository;

import org.springframework.stereotype.Repository;
import org.ifba.web.bd.projectbanco.model.Usuario;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
