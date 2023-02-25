package org.ifba.web.bd.projectbanco.service;

import java.util.List;

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
    public List<Cliente> getAll(){
        return(List<Cliente>) clienteRepository.findAll();
    } 
    public Cliente getCliente(Long id){
        return clienteRepository.findById(id).get();
    }
    public void editarCliente(Long id, Cliente cliente){ 
        Cliente cliente2 = getCliente(id);
        if(cliente.getCpf().isEmpty()){
            cliente.setCpf(cliente2.getCpf());
        }
        if(cliente.getRua().isEmpty()){
            cliente.setRua(cliente2.getRua());
        }
        if(cliente.getCidade().isEmpty()){
            cliente.setCidade(cliente2.getCidade());
        }
        if(cliente.getEmail().isEmpty()){
            cliente.setEmail(cliente2.getEmail());
        }
        if(cliente.getNome().isEmpty()){
            cliente.setEmail(cliente2.getEmail());
        }
        cliente.setId(id);
        clienteRepository.save(cliente);
        
    }
    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
