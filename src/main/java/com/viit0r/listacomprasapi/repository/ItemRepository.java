package com.viit0r.listacomprasapi.repository;

import com.viit0r.listacomprasapi.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM item WHERE id_lista = :id", nativeQuery = true)
    List<Item> findByIdLista(@Param("id") Long id);
}
