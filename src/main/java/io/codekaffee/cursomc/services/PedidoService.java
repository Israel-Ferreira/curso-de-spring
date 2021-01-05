package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import io.codekaffee.cursomc.exceptions.nfex.PedidoNotFoundException;
import io.codekaffee.cursomc.models.ItemPedido;
import io.codekaffee.cursomc.models.PagamentoBoleto;
import io.codekaffee.cursomc.models.Pedido;
import io.codekaffee.cursomc.repositories.ItemPedidoRepository;
import io.codekaffee.cursomc.repositories.PagamentoRepository;
import io.codekaffee.cursomc.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    private final PagamentoRepository pagamentoRepository;

    private final BoletoService boletoService;
    private final ProdutoService produtoService;
    private final ItemPedidoRepository itemPedidoRepository;


    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, BoletoService boletoService, ProdutoService produtoService, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.boletoService = boletoService;
        this.produtoService = produtoService;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public Pedido getById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(PedidoNotFoundException::new);
    }

    @Transactional
    public Pedido insert(Pedido pedido){
        pedido.setId(null);
        pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);

        if(pedido.getPagamento() instanceof PagamentoBoleto){
            PagamentoBoleto pgto = (PagamentoBoleto) pedido.getPagamento();
            boletoService.preencherPagamentoComBoleto(pgto, LocalDate.now());
        }

        pedido = pedidoRepository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());

        for (ItemPedido item: pedido.getItems()) {
            var produto = produtoService.getProduto(item.getProduto().getId());
            item.setDesconto(0.0);
            item.setPreco(produto.getPreco());
            item.setPedido(pedido);
        }

        itemPedidoRepository.saveAll(pedido.getItems());

        return pedido;
    }
}
