package com.viit0r.listacomprasapi.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lista")
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
}
