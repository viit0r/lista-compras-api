package com.viit0r.listacomprasapi.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "produto")
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Builder
    public Produto(String nome, Double valorUnitario) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }
}
