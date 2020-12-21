package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Categoria;
import io.codekaffee.cursomc.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty
    @NotBlank
    @Length(min = 5)
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
