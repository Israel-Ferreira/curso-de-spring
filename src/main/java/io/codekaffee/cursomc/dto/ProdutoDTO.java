package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProdutoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY )
    private Long id;

    private String nome;
    private Double preco;

    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<CategoriaDTO> categorias = new ArrayList<>();


    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

}
