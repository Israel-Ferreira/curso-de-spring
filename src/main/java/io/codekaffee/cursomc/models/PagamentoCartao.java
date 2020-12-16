package io.codekaffee.cursomc.models;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoCartao extends Pagamento{
    private Integer numeroParcelas;

    public PagamentoCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
