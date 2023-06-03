package com.viit0r.listacomprasapi.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "lista")
@Getter
@NoArgsConstructor
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long id;

    @Column(name = "nome_lista")
    private String nome;

    @Column(name = "dt_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "limite_gasto")
    private Double limiteGasto;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Builder
    public Lista(String nome, Date dataCriacao, Double limiteGasto, Double valorTotal) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.limiteGasto = limiteGasto;
        this.valorTotal = valorTotal;
    }
}
