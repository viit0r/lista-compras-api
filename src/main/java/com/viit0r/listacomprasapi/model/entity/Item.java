package com.viit0r.listacomprasapi.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "item")
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column
    private Boolean coletado;

    @Column(name = "qtde_item")
    private Integer qtde;

    @Column(name = "valor_total_itens")
    private Double valorTotal;

    @OneToOne
    @JoinColumn(name = "id_produto", foreignKey = @ForeignKey(name="fk_id_produto"), nullable = false)
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "id_lista", foreignKey = @ForeignKey(name="fk_id_lista"), nullable = false)
    private Lista lista;
}
