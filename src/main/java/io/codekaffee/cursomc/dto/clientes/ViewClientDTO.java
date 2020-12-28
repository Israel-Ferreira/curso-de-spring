package io.codekaffee.cursomc.dto.clientes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.dto.enderecos.ViewEnderecoDTO;
import io.codekaffee.cursomc.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ViewClientDTO extends ClienteDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ViewEnderecoDTO> enderecos = new ArrayList<>();

    @Size(min = 1, message = "O Usuário deve ter no minimo 1 Telefone")
    private Set<String> telefones = new HashSet<>();


    public ViewClientDTO(Cliente cliente) {
        super(cliente);
        this.id = cliente.getId();
        this.enderecos = ViewEnderecoDTO.convertEnderecoListToDTO(cliente.getEnderecos());
        this.telefones = cliente.getTelefones();
    }
}
