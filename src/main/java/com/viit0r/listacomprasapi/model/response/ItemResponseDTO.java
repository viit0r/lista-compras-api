package com.viit0r.listacomprasapi.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viit0r.listacomprasapi.model.entity.Item;
import com.viit0r.listacomprasapi.util.Mapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Setter
public class ItemResponseDTO implements Serializable {

    private Long id;
    private Boolean coletado;
    private Integer qtde;
    private Double valorTotal;
    private ProdutoResponseDTO produto;
    private ListaResponseDTO lista;

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    private final Mapper itemMapper = new Mapper();

    public ItemResponseDTO(Item item) {
        this.id = item.getId();
        this.coletado = item.getColetado();
        this.qtde = item.getQtde();
        this.valorTotal = item.getValorTotal();
        this.produto = itemMapper.toProdutoDTO(item.getProduto());
        this.lista = itemMapper.toListaDTO(item.getLista());
    }
}
