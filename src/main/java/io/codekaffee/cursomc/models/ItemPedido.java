package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
public class ItemPedido {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        this.id =  new ItemPedidoPK();
        this.id.setPedido(pedido);
        this.setProduto(produto);

        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade){
        this.id = new ItemPedidoPK(produto, pedido);
        this.desconto = desconto;
        this.quantidade = quantidade;
    }


    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public Double getSubTotal(){
        Double precoProduto = getProduto().getPreco();
        return (precoProduto * quantidade) - desconto;
    }


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Produto getProduto(){
        return id.getProduto();
    }


    public void setProduto(Produto produto){
        System.out.println(produto.getNome());
        this.id.setProduto(produto);
    }

    public void setPedido(Pedido pedido){
        this.id.setPedido(pedido);
    }

}
