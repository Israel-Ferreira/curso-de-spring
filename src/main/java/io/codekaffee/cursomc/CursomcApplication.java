package io.codekaffee.cursomc;

import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.models.Produto;
import io.codekaffee.cursomc.repositories.CategoriaRepository;
import io.codekaffee.cursomc.repositories.ProdutoRepository;
import io.codekaffee.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaService categoriaService;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Produto p1 =  new Produto("Macbook Air 12 Pol.", 6500.00);
        Produto p2 =   new Produto("Impressora HP Deskjet 3890", 860.00);
        Produto p3 = new Produto("Perfume Boticario Malbec 150ml", 215.00);
        Produto p4 = new Produto("Jogo X-Wing Miniature Game", 350.00);


        Categoria cat1 = new Categoria("Informatica");
        Categoria cat2 = new Categoria("Perfumaria");
        Categoria cat3 = new Categoria("Jogos de Tabuleiro");
        Categoria cat4 = new Categoria("Escritório");

        cat1.getProdutos().addAll(Arrays.asList(p1, p2));

        cat4.getProdutos().add(p2);
        cat2.getProdutos().add(p3);
        cat3.getProdutos().add(p4);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p3.getCategorias().add(cat2);
        p4.getCategorias().add(cat3);


        List<Categoria> categorias = Arrays.asList(cat1, cat2, cat3, cat4);

        categoriaRepository.saveAll(categorias);
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}
