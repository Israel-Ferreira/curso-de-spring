package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.clientes.PostClientDTO;
import io.codekaffee.cursomc.exceptions.DataIntegrityException;
import io.codekaffee.cursomc.exceptions.nfex.ClienteNotFoundException;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.models.Endereco;
import io.codekaffee.cursomc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private CidadeService cidadeService;


    @Transactional
    public  Cliente insert(PostClientDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO);

        Cidade cidade = cidadeService.findByNome(clienteDTO.getEndereco().getCidade());
        Endereco endereco = new Endereco(clienteDTO.getEndereco(), cliente, cidade);

        cliente.getEnderecos().add(endereco);

        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNotFoundException::new);
    }

    public Page<Cliente> findClientesPage(Pageable pageable){
        return clienteRepository.findAll(pageable);
    }

    public Cliente findByEmail(String email){
        return clienteRepository.findByEmail(email)
                .orElseThrow(ClienteNotFoundException::new);
    }

    public Cliente update(Long id,ClienteDTO clienteDTO){
        return clienteRepository.findById(id)
                .map(cliente -> {
                    Cliente cl1 = fromDtoUpdate(clienteDTO, cliente);
                    return this.clienteRepository.save(cl1);
                })
                .orElseThrow(ClienteNotFoundException::new);
    }


    public void deleteById(Long id){
        try {
            Cliente cliente = this.findById(id);
            this.clienteRepository.delete(cliente);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("Não tem como deletar um cliente com pedidos",exception.getCause());
        }
    }

    private Cliente fromDtoUpdate(ClienteDTO clienteDTO, Cliente oldCliente){
        oldCliente.setNome(clienteDTO.getNome());
        oldCliente.setEmail(clienteDTO.getEmail());

        return oldCliente;
    }

}
