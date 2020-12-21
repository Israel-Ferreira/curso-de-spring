package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.exceptions.nfex.ClienteNotFoundException;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public  Cliente insert(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNotFoundException::new);
    }

    public Cliente findByEmail(String email){
        return clienteRepository.findByEmail(email)
                .orElseThrow(ClienteNotFoundException::new);
    }


    public void deleteById(Long id){
        Cliente cliente = this.findById(id);
        this.clienteRepository.delete(cliente);
    }



}
