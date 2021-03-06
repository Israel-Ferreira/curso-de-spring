package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import io.codekaffee.cursomc.exceptions.nfex.PedidoNotFoundException;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.models.ItemPedido;
import io.codekaffee.cursomc.models.PagamentoBoleto;
import io.codekaffee.cursomc.models.Pedido;
import io.codekaffee.cursomc.repositories.ItemPedidoRepository;
import io.codekaffee.cursomc.repositories.PagamentoRepository;
import io.codekaffee.cursomc.repositories.PedidoRepository;
import io.codekaffee.cursomc.services.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteService clienteService;
    private final PagamentoRepository pagamentoRepository;

    private final BoletoService boletoService;
    private final ProdutoService produtoService;
    private final ItemPedidoRepository itemPedidoRepository;

    private final EmailService emailService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, BoletoService boletoService, ProdutoService produtoService, ItemPedidoRepository itemPedidoRepository, ClienteService clienteService, EmailService emailService) {
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.boletoService = boletoService;
        this.produtoService = produtoService;
        this.itemPedidoRepository = itemPedidoRepository;
        this.emailService =  emailService;
    }

    public Pedido getById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(PedidoNotFoundException::new);
    }

    @Transactional
    public Pedido insert(Pedido pedido){
        Cliente cliente = this.clienteService.findById(pedido.getCliente().getId());
        pedido.setId(null);
        pedido.setCliente(cliente);
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
            item.setProduto(produto);
            item.setDesconto(0.0);
            item.setPreco(produto.getPreco());
            item.setPedido(pedido);
        }

        itemPedidoRepository.saveAll(pedido.getItems());

        this.emailService.sendOrderConfirmationEmail(pedido);

        return pedido;
    }
}
