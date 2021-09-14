package io.github.ErickFernandes_Algnologia.domain.repository;

import io.github.ErickFernandes_Algnologia.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
