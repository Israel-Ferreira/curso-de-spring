package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
