package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.models.Pedido;
import io.codekaffee.cursomc.services.PedidoService;
import io.codekaffee.cursomc.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable("id") Long id){
        Pedido pedido = pedidoService.getById(id);
        return  ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Void> createPedido(@RequestBody Pedido pedido){
        Pedido pedido1 = this.pedidoService.insert(pedido);
        System.out.println(pedido1.toString());

        URI uri = ResourceUtils.resourceURI(pedido1.getId());
        return ResponseEntity.created(uri).build();
    }



}
