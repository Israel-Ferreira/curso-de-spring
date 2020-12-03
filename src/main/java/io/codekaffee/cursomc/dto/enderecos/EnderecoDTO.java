package io.codekaffee.cursomc.dto.enderecos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String complemento;

    private String bairro;
    private String cep;



    public EnderecoDTO(Endereco endereco){
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();

        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
    }

}
