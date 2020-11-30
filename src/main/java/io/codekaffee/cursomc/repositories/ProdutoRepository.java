package io.codekaffee.cursomc.repositories;

import io.codekaffee.cursomc.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
