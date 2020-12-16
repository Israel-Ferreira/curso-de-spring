package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
