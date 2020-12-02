package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.dto.ClienteDTO;
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

        return ResponseEntity.ok(clienteDTO);
    }
    
    @PostMapping
    public ResponseEntity<Cliente> insertClient(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + cliente.getId()).build().toUri();


        return ResponseEntity.created(uri).body(cliente);
    }









}
