package io.codekaffee.cursomc.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PedidoDTO {
    @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
    private LocalDateTime instante;


}
