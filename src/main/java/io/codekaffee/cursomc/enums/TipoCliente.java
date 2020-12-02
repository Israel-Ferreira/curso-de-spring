package io.codekaffee.cursomc.enums;

import java.util.Arrays;

public enum TipoCliente {
    PESSOA_FISICA(1L, "Pessoa Fisica"),
    PESSOA_JURIDICA(2L, "Pessoa Juridica");

    private Long id;
    private String descricao;

    TipoCliente(Long id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Long id){
         return  Arrays.stream(TipoCliente.values())
                 .filter(tipoCliente -> tipoCliente.getId().equals(id))
                 .findFirst()
                 .orElseThrow(IllegalArgumentException::new);
    }
}
