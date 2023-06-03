package com.viit0r.listacomprasapi.repository;

import com.viit0r.listacomprasapi.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
