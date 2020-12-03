package io.codekaffee.cursomc.dto.enderecos;


import io.codekaffee.cursomc.dto.location.CidadeDTO;
import io.codekaffee.cursomc.models.Endereco;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NewEnderecoDTO extends EnderecoDTO {

    private String cidade;

    public NewEnderecoDTO(String logradouro, String numero, String complemento, String bairro, String cep, String cidade) {
        super(logradouro, numero, complemento, bairro, cep);
        this.cidade = cidade;
    }

    public NewEnderecoDTO(Endereco endereco, String cidade) {
        super(endereco);
        this.cidade = cidade;
    }
}
