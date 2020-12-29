package io.codekaffee.cursomc.dto.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.annotations.ClientInsert;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ClientInsert
@EqualsAndHashCode(callSuper = true)
public class PostClientDTO extends ClienteDTO {

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long tipoClientID;


    @Valid
    @NotNull(message = "Preenchimento Obrigatório")
    private NewEnderecoDTO endereco;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String cpfOrCnpj;


    @Size(min = 1, message = "O Usuário deve ter no minimo 1 Telefone")
    private Set<String> telefones = new HashSet<>();

}
