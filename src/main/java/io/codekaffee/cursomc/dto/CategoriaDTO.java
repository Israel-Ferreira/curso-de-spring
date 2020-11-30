package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nome;


    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProdutoDTO> produtos = new ArrayList<>();

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public void fillProdutosList(List<Produto> produtos){
        List<ProdutoDTO> products = produtos.stream().map(ProdutoDTO::new)
                .collect(Collectors.toList());
        this.setProdutos(products);
    }
}
