package io.codekaffee.cursomc.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;


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
        this.preco = produto.getPreco();
    }


    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }

    public double getSubTotal(){
        return (preco * quantidade) - desconto;
    }


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Produto getProduto(){
        return id.getProduto();
    }


    public void setProduto(Produto produto){
        this.id.setProduto(produto);
    }

    public void setPedido(Pedido pedido){
        this.id.setPedido(pedido);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        final StringBuilder sb = new StringBuilder();

        sb.append(this.getProduto().getNome());
        sb.append(", Qte: ");
        sb.append(this.getQuantidade());
        sb.append(", Preço unitário: ");
        sb.append(nf.format(this.getPreco()));
        sb.append(", Subtotal: ");
        sb.append(nf.format(this.getSubTotal()));

        sb.append("\n");
        return sb.toString();
    }
}
