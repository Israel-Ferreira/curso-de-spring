package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.annotations.ApiPageable;
import io.codekaffee.cursomc.dto.ProdutoDTO;
import io.codekaffee.cursomc.models.Produto;
import io.codekaffee.cursomc.services.ProdutoService;
import io.codekaffee.cursomc.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ApiPageable
    public ResponseEntity<Page<ProdutoDTO>> getAll(@ApiIgnore @PageableDefault(size = 24, value = 0) Pageable pageable ){
        Page<ProdutoDTO> produtos = produtoService.findAll(pageable).map(ProdutoDTO::new);
        return ResponseEntity.ok(produtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id){
        Produto produto = produtoService.getProduto(id);
        ProdutoDTO response = new ProdutoDTO(produto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/search")
    @ApiPageable
    public ResponseEntity<Page<ProdutoDTO>> search(@RequestParam String nome, @ApiIgnore @PageableDefault Pageable pageable, @RequestParam List<Long> idCategorias){
        Page<Produto> produtos = produtoService.search(nome, pageable, idCategorias);
        Page<ProdutoDTO> responses = produtos.map(ProdutoDTO::new);
        return ResponseEntity.ok(responses);
    }


    @PostMapping
    public ResponseEntity<Void> insertProduto(@RequestBody ProdutoDTO produtoDTO){
        Produto produto = produtoService.createProduct(produtoDTO);
        URI uri = ResourceUtils.resourceURI(produto.getId());

        return ResponseEntity.created(uri).build();
    }
}
