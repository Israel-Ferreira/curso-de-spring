package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.annotations.ApiPageable;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.clientes.PostClientDTO;
import io.codekaffee.cursomc.dto.clientes.ViewClientDTO;
import io.codekaffee.cursomc.dto.enderecos.EnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.ViewEnderecoDTO;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.services.ClienteService;
import io.codekaffee.cursomc.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ViewClientDTO> getById(@PathVariable("id") Long id){
        Cliente cliente = clienteService.findById(id);

        ViewClientDTO clienteDTO = new ViewClientDTO(cliente);
        clienteDTO.setEnderecos(ViewEnderecoDTO.convertEnderecoListToDTO(cliente.getEnderecos()));

        return ResponseEntity.ok(clienteDTO);
    }


    @ApiPageable
    @GetMapping("/page")
    public ResponseEntity<Page<ClienteDTO>> getClientesPage(@ApiIgnore @PageableDefault(size = 24, value = 0) Pageable pageable){
        Page<ClienteDTO> clientes = clienteService.findClientesPage(pageable).map(ClienteDTO::new);
        return ResponseEntity.ok(clientes);
    }

    
    @PostMapping
    public ResponseEntity<Cliente> insertClient(@RequestBody @Valid PostClientDTO clienteDTO){
        Cliente cliente = this.clienteService.insert(clienteDTO);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/" + cliente.getId()).build().toUri();


        return ResponseEntity.created(uri).body(cliente);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        this.clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        Cliente cliente =  this.clienteService.update(id, clienteDTO);
        URI uri = ResourceUtils.resourceURI(cliente.getId());
        return ResponseEntity.noContent().location(uri).build();
    }

}
