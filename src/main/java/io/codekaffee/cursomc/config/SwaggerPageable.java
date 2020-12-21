package io.codekaffee.cursomc.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwaggerPageable {
    private Integer size;
    private Integer page;
    private String sort;
}
