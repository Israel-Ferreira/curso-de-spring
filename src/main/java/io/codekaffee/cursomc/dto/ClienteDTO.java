package io.codekaffee.cursomc.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.annotations.ClientUpdate;
import io.codekaffee.cursomc.dto.enderecos.EnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import io.codekaffee.cursomc.dto.enderecos.ViewEnderecoDTO;
import io.codekaffee.cursomc.models.Cliente;
import io.codekaffee.cursomc.models.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Length(min = 6, max=120, message = "O  tamanho deve ter entre 6 & 120 caracteres")
    private String nome;

    @Email
    @NotEmpty(message = "Preenchimento Obrigatorio")
    private String email;


    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }



}
