package io.codekaffee.cursomc.enums;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2,"Quitado"), CANCELADO(3, "Cancelado");


    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String  descricao;

    private EstadoPagamento(Integer id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }


}
