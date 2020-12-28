package io.codekaffee.cursomc.dto.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostClientDTO extends ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long tipoClientID;


    private NewEnderecoDTO enderecoDTO;

    private String cpfOrCnpj;


    @Size(min = 1, message = "O Usuário deve ter no minimo 1 Telefone")
    private Set<String> telefones = new HashSet<>();

}
