package io.codekaffee.cursomc.services;

import io.codekaffee.cursomc.models.PagamentoBoleto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BoletoService {
    public void preencherPagamentoComBoleto(PagamentoBoleto pgto, LocalDate instante){
        LocalDate dataVencimento = instante.plusDays(7);
        pgto.setDataVencimento(dataVencimento);
    }
}
