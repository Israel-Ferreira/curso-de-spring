package io.codekaffee.cursomc.dto.location;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Estado;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class CidadeDTO {
    private Long id;
    private String nome;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String siglaEstado;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String nomeEstado;


    public CidadeDTO(String nome) {
        this.nome = nome;
    }

    public CidadeDTO(Cidade cidade){
        this.id = cidade.getId();
        this.nome = cidade.getNome();
    }

}
