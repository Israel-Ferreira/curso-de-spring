package io.codekaffee.cursomc.models;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoBoleto extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;


    public PagamentoBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
