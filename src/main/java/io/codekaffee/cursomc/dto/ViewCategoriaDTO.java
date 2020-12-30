package io.codekaffee.cursomc.dto;

import io.codekaffee.cursomc.models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewCategoriaDTO {
    private Long id;
    private String nome;

    public ViewCategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
