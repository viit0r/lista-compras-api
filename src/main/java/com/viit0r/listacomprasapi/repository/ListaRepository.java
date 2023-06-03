package com.viit0r.listacomprasapi.repository;

import com.viit0r.listacomprasapi.model.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long> {
}
