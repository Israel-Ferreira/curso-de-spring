package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;


    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "pedido_id")
    @JsonBackReference
    private Pedido pedido;


    public ItemPedidoPK(Produto produto, Pedido pedido){
        this.produto = produto;
        this.pedido = pedido;
    }
}
