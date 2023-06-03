package com.viit0r.listacomprasapi.repository;

import com.viit0r.listacomprasapi.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
