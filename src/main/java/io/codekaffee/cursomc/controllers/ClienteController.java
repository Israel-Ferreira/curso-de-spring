package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.enderecos.EnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.ViewEnderecoDTO;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable("id") Long id){
        Cliente cliente = clienteService.findById(id);

        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        clienteDTO.setEnderecos(ViewEnderecoDTO.convertEnderecoListToDTO(cliente.getEnderecos()));

        return ResponseEntity.ok(clienteDTO);
    }
    
    @PostMapping
    public ResponseEntity<Cliente> insertClient(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = this.clienteService.insert(clienteDTO);


        System.out.println(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/" + cliente.getId()).build().toUri();


        return ResponseEntity.created(uri).body(cliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        this.clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
