package io.codekaffee.cursomc.models;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemPedidoPK id;

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        this.id =  new ItemPedidoPK(produto, pedido);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade){
        this.id = new ItemPedidoPK(produto, pedido);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = getProduto().getPreco() * quantidade;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public Produto getProduto(){
        return id.getProduto();
    }

}
