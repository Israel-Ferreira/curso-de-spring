package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String complemento;

    private String bairro;
    private String cep;

    private Cidade cidade;

    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ClienteDTO cliente;

    public EnderecoDTO(Endereco endereco){
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();

        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.cliente = new ClienteDTO(endereco.getCliente());
    }


}
