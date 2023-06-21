package com.viit0r.listacomprasapi.model.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ItemRequestDTO implements Serializable {
    private Boolean coletado;
    private Integer qtde;
    private ProdutoRequestDTO produto;
    private ListaRequestDTO lista;
}
