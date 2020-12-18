package io.codekaffee.cursomc.dto.clientes;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.enderecos.NewEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostClientDTO extends ClienteDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long tipoClientID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private NewEnderecoDTO enderecoDTO;

}
