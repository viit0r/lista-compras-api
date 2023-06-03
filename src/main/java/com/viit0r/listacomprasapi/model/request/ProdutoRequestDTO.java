package com.viit0r.listacomprasapi.model.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProdutoRequestDTO implements Serializable {
    private Long id;
    private String nome;
    private Double valorUnitario;
}
