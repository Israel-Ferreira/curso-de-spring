package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeAndSigla(String nome, String sigla);
}
