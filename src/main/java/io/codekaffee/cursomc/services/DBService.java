package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import io.codekaffee.cursomc.enums.TipoCliente;
import io.codekaffee.cursomc.models.*;
import io.codekaffee.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {
    private final CategoriaRepository categoriaRepository;

    private final ProdutoRepository produtoRepository;

    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;

    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public DBService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, EstadoRepository estadoRepository, CidadeRepository cidadeRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public void instantiateTestDatabase() throws ParseException {
        Produto p1 =  new Produto("Macbook Air 12 Pol.", 6500.00);
        Produto p2 =   new Produto("Impressora HP Deskjet 3890", 860.00);
        Produto p3 = new Produto("Perfume Boticario Malbec 150ml", 215.00);
        Produto p4 = new Produto("Jogo X-Wing Miniature Game", 350.00);

        Produto p5 = new Produto("Mesa de Escritório", 450.00);
        Produto p6 = new Produto("SSD Samsung 480 GB", 650.00);
        Produto p7 = new Produto("Smartphone Xiaomi Mi 10", 4600.00);
        Produto p8 = new Produto("Playstation 5", 5000.00);
        Produto p9 = new Produto("Mouse Logitech G92", 4500.00 );
        Produto p10 = new Produto("Conj. de 6 toalhas grandes Santista ",100.00);
        Produto p11 = new Produto("Smartphone Motorola Moto G8 64 GB", 1300.00);
        Produto p12 = new Produto("Notebook Gamer Samsung Odissey, 1 TB HD, 128 GB SSD, 16 GB RAM, Placa de Video RTX 2060 6GB", 5700.00);


        Categoria cat1 = new Categoria("Informatica");
        Categoria cat2 = new Categoria("Perfumaria");
        Categoria cat3 = new Categoria("Jogos de Tabuleiro");
        Categoria cat4 = new Categoria("Escritório");

        Categoria cat5 = new Categoria("Vestuário");
        Categoria cat6 = new Categoria("Cama,Mesa e Banho");
        Categoria cat7 = new Categoria("Games");
        Categoria cat8 = new Categoria("Eletrônicos");
        Categoria cat9 = new Categoria("Eletrodosmeticos");
        Categoria cat10 = new Categoria("Telefonia e Smartphones");


        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p6, p9, p12));
        cat7.getProdutos().addAll(Arrays.asList(p8,p9, p12));
        cat10.getProdutos().addAll(Arrays.asList(p7, p11));


        cat4.getProdutos().addAll(Arrays.asList(p2,p5));
        cat2.getProdutos().add(p3);
        cat3.getProdutos().add(p4);

        cat6.getProdutos().add(p10);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p3.getCategorias().add(cat2);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat4);
        p8.getCategorias().add(cat7);
        p6.getCategorias().add(cat1);
        p7.getCategorias().add(cat10);
        p9.getCategorias().addAll(Arrays.asList(cat1,cat7));
        p10.getCategorias().add(cat6);
        p11.getCategorias().add(cat10);
        p12.getCategorias().add(cat1);



        List<Categoria> categorias = Arrays.asList(cat1, cat2, cat3, cat4, cat5,cat6, cat7, cat8, cat9, cat10);

        categoriaRepository.saveAll(categorias);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4,p5,p6,p7,p8,p9,p10,p11,p12));

        Estado saoPaulo  =  new Estado("São Paulo", "SP");
        Estado pernambuco = new Estado("Pernambuco", "PE");
        Estado minas =  new Estado("Minas Gerais", "MG");

        List<Cidade> cidades =  Arrays.asList(
                new Cidade("Jundiaí", saoPaulo),
                new Cidade("Olinda", pernambuco),
                new Cidade("São Lourenço", minas)
        );

        estadoRepository.saveAll(Arrays.asList(saoPaulo, pernambuco, minas));
        cidadeRepository.saveAll(cidades);

        Cliente cliente = new Cliente("Israel Souza", "israelfsouza@hotmail.com", "412.016.540-09", TipoCliente.PESSOA_FISICA);
        cliente.getTelefones().addAll(Arrays.asList("(11) 999073020", "(11) 55555-5555"));

        Cidade cidade = new Cidade("São Paulo", saoPaulo);

        Endereco endereco1 = new Endereco("Av. Paulista","2073",null,"Consolação", "01311-300");
        endereco1.setCidade(cidade);
        endereco1.setCliente(cliente);

        Endereco endereco2 = new Endereco("Rua Voluntários da Patria", " 1176", null, "Santana", "02010-100");
        endereco2.setCidade(cidade);
        endereco2.setCliente(cliente);


        cidadeRepository.save(cidade);

        cliente.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
        clienteRepository.save(cliente);

        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));




        Pedido pedido1 = new Pedido(endereco2, cliente);
        Pagamento pagamento1 =  new PagamentoCartao(EstadoPagamento.QUITADO, pedido1, 6);


        Pedido pedido2 = new Pedido(endereco1, cliente);

        LocalDate dataVencimento = LocalDate.of(2021, Month.JANUARY, 30);
        LocalDate dataPagamento = LocalDate.of(2020, Month.DECEMBER, 1);

        Pagamento pagamento2 = new PagamentoBoleto(EstadoPagamento.PENDENTE, pedido2,dataVencimento, dataPagamento);

        pedido1.setPagamento(pagamento1);
        pedido2.setPagamento(pagamento2);

        cliente.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
        pagamentoRepository.saveAll(Arrays.asList(pagamento1, pagamento2));

        clienteRepository.save(cliente);

        ItemPedido itemPedido1 = new ItemPedido(pedido1,p1,500.00, 6);
        ItemPedido itemPedido2 = new ItemPedido(pedido2, p3,50.00 , 3);
        ItemPedido itemPedido3 = new ItemPedido(pedido2, p8, 600.00, 1);

        pedido1.getItems().add(itemPedido1);
        pedido2.getItems().add(itemPedido2);
        pedido2.getItems().add(itemPedido3);

        p1.getItemPedidos().add(itemPedido1);
        p3.getItemPedidos().add(itemPedido2);
        p8.getItemPedidos().add(itemPedido3);


        produtoRepository.saveAll(Arrays.asList(p1, p3));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
    }
}
