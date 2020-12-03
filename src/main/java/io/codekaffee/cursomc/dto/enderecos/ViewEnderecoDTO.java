package io.codekaffee.cursomc.dto.enderecos;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.models.Cidade;
import io.codekaffee.cursomc.models.Endereco;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;


@Data
@EqualsAndHashCode(callSuper = true)
public class ViewEnderecoDTO extends EnderecoDTO {

    private Long id;

    private Cidade cidade;

    @JsonBackReference
    private ClienteDTO cliente;


    public ViewEnderecoDTO(Endereco endereco) {
        super(endereco);
        this.id = endereco.getId();
        this.cidade = endereco.getCidade();
        this.cliente = new ClienteDTO(endereco.getCliente());
    }


    public static List<ViewEnderecoDTO> convertEnderecoListToDTO(List<Endereco> enderecos){
        return enderecos.stream().map(ViewEnderecoDTO::new)
                .collect(Collectors.toList());
    }
}
