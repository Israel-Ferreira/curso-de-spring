package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ProdutoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY )
    private Long id;

    private String nome;
    private Double preco;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Long>  categoriasIds = new ArrayList<>();


    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<CategoriaDTO> categorias = new ArrayList<>();


    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ViewCategoriaDTO> productCategories = new ArrayList<>();




    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.productCategories = produto.getCategorias().stream()
                .map(ViewCategoriaDTO::new).collect(Collectors.toList());
    }

}
