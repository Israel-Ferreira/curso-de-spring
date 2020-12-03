package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findByNomeContainingIgnoringCase(String nome);
}
