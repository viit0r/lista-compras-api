package com.viit0r.listacomprasapi.model.request;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class ListaRequestDTO implements Serializable {

    private Long id;
    private String nome;
    private Date dataCriacao;
    private Double limiteGasto;
    private Double valorTotal;
}
