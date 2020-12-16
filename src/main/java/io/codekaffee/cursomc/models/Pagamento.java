package io.codekaffee.cursomc.models;


import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pagamento {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoPagamento estadoPagamento;

    @MapsId
    @OneToOne
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
