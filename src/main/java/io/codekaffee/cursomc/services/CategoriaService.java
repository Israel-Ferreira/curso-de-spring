package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.dto.CategoriaDTO;
import io.codekaffee.cursomc.exceptions.categoria.CategoriaNotFoundException;
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



    public Categoria create(CategoriaDTO dto){
        Categoria categoria =  new Categoria(dto.getNome());
        return repository.save(categoria);
    }


    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria update(Long id, CategoriaDTO categoriaDTO){
        return repository.findById(id)
                .map(categoria -> {
                    categoria.setNome(categoriaDTO.getNome());
                    return repository.save(categoria);
                })
                .orElseThrow(CategoriaNotFoundException::new);
    }


    public Categoria findById(Long id){
        return repository.findById(id)
                .orElseThrow(CategoriaNotFoundException::new);
    }

    public void delete(Long id){
        var categoria = this.findById(id);
        repository.delete(categoria);
    }
}
