package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;


    public List<Categoria> loadInitialPayload(){
        List<Categoria> categorias = Arrays.asList(
                new Categoria("Informatica"),
                new Categoria("Perfumaria"),
                new Categoria("Jogos de Tabuleiro")
        );

        return repository.saveAll(categorias);
    }
}
