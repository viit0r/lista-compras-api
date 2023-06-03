package com.viit0r.listacomprasapi.model.response;

import com.viit0r.listacomprasapi.model.entity.Lista;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class ListaResponseDTO implements Serializable {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Double limiteGasto;
    private Double valorTotal;

    public ListaResponseDTO(Lista lista) {
        this.id = lista.getId();
        this.nome = lista.getNome();
        this.dataCriacao = lista.getDataCriacao();
        this.limiteGasto = lista.getLimiteGasto();
        this.valorTotal = lista.getValorTotal();
    }
}
