package com.viit0r.listacomprasapi.model.response;

import com.viit0r.listacomprasapi.model.entity.Produto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProdutoResponseDTO implements Serializable {
    private Long id;
    private String nome;
    private Double valorUnitario;

    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valorUnitario = produto.getValorUnitario();
    }
}