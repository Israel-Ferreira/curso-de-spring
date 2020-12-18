package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.dto.CategoriaDTO;
import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getCategorias(){
        var categorias = categoriaService.findAll();

        List<CategoriaDTO> categoriaDTOS =  categorias.stream()
                .map(cat -> {
                    var category = new CategoriaDTO(cat);
                    category.fillProdutosList(cat.getProdutos());
                    return category;
                }).collect(Collectors.toList());

        return ResponseEntity.ok(categoriaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable("id") Long id){
        Categoria categoria =  categoriaService.findById(id);
        CategoriaDTO response =  new CategoriaDTO(categoria);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        var categoria = categoriaService.update(id, categoriaDTO);
        CategoriaDTO response =  new CategoriaDTO(categoria);
        return  ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        this.categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<Void> createCategoria(@RequestBody CategoriaDTO body){
        Categoria categoria = categoriaService.create(body);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/" + categoria.getId()).build().toUri();


        CategoriaDTO response = new CategoriaDTO(categoria);

        return ResponseEntity.created(uri).build();
    }
}
