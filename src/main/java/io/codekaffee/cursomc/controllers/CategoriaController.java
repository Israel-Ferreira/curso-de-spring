package io.codekaffee.cursomc.controllers;

import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        var categorias = categoriaService.loadInitialPayload();
        return ResponseEntity.ok(categorias);
    }
}
