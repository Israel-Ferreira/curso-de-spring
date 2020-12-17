package io.codekaffee.cursomc.models;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PagamentoCartao extends Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroParcelas) {
        super(estadoPagamento, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
