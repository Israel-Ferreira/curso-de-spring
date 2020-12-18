package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.models.Pedido;
import io.codekaffee.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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



}
