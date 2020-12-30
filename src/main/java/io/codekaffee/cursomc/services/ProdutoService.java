package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.dto.ProdutoDTO;
import io.codekaffee.cursomc.exceptions.nfex.NotFoundException;
import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.models.Produto;
import io.codekaffee.cursomc.repositories.CategoriaRepository;
import io.codekaffee.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Page<Produto> search(String nome, Pageable pageable, List<Long> categoriaIds){
        List<Categoria> categorias = categoriaRepository.findAllById(categoriaIds);
        return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageable);
    }

    public Produto getProduto(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }



    public Produto createProduct(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);
        List<Categoria> categorias = categoriaRepository.findAllById(produtoDTO.getCategoriasIds());

        produto.getCategorias().addAll(categorias);

        return produtoRepository.save(produto);
    }

    public Page<Produto> findAll(Pageable pageable){
        return produtoRepository.findAll(pageable);
    }
}
