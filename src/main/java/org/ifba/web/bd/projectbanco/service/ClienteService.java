package org.ifba.web.bd.projectbanco.service;

import org.ifba.web.bd.projectbanco.model.Cliente;
import org.ifba.web.bd.projectbanco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void saveCliente( Cliente cliente){
        clienteRepository.save(cliente);
    }
}
