package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
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

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Produto getProduto(){
        return id.getProduto();
    }

}
