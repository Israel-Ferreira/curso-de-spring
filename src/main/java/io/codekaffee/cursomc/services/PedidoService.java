package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.exceptions.nfex.PedidoNotFoundException;
import io.codekaffee.cursomc.models.Pedido;
import io.codekaffee.cursomc.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido getById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(PedidoNotFoundException::new);
    }

    public Pedido insert(Pedido pedido){
        System.out.println(pedido);
        return pedido;
    }
}
