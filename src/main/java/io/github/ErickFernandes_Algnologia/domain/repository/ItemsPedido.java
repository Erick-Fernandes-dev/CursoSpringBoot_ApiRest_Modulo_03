package io.github.ErickFernandes_Algnologia.domain.repository;

import io.github.ErickFernandes_Algnologia.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
