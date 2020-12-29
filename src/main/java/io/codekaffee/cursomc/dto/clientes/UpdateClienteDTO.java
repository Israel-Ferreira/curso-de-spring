package io.codekaffee.cursomc.dto.clientes;

import io.codekaffee.cursomc.annotations.ClientUpdate;
import io.codekaffee.cursomc.dto.ClienteDTO;
import io.codekaffee.cursomc.models.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@ClientUpdate
@EqualsAndHashCode(callSuper = true)
public class UpdateClienteDTO extends ClienteDTO {
    public UpdateClienteDTO() {
    }

    public UpdateClienteDTO(Cliente cliente) {
        super(cliente);
    }
}
