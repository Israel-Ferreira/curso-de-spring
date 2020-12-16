package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,  Long> {
}
