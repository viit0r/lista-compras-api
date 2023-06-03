package com.viit0r.listacomprasapi.model.response;

import com.viit0r.listacomprasapi.model.entity.Item;
import com.viit0r.listacomprasapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ItemResponseDTO implements Serializable {

    private Long id;
    private Boolean coletado;
    private Integer qtde;
    private Double valorTotal;
    private ProdutoResponseDTO produto;
    private ListaResponseDTO lista;

    @Autowired
    private Mapper itemMapper;

    public ItemResponseDTO(Item item) {
        this.id = item.getId();
        this.coletado = item.getColetado();
        this.valorTotal = item.getValorTotal();
        this.produto = itemMapper.toProduto(item.getProduto());
        this.lista = itemMapper.toLista(item.getLista());
    }
}
