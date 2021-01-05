package io.codekaffee.cursomc.models;


import com.fasterxml.jackson.annotation.*;
import io.codekaffee.cursomc.dto.ProdutoDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double preco;


    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id.produto")
    private Set<ItemPedido> itemPedidos =  new HashSet<>();

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(ProdutoDTO dto){
        this.nome = dto.getNome();
        this.preco = dto.getPreco();
    }


    @JsonIgnore
    public List<Pedido> getPedidos(){
        return itemPedidos.stream().map(ItemPedido::getPedido)
                .collect(Collectors.toList());
    }




}
