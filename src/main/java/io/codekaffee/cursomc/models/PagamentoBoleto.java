package io.codekaffee.cursomc.models;

import io.codekaffee.cursomc.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PagamentoBoleto extends Pagamento{

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;


    public PagamentoBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
