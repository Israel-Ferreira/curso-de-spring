package io.codekaffee.cursomc.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoPagamento estadoPagamento;

    @MapsId
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public Pagamento(EstadoPagamento estadoPagamento, Pedido pedido){
        this.estadoPagamento = estadoPagamento;
        this.pedido = pedido;
    }

}
