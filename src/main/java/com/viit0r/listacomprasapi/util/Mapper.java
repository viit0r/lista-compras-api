package com.viit0r.listacomprasapi.util;

import com.viit0r.listacomprasapi.model.entity.Item;
import com.viit0r.listacomprasapi.model.entity.Lista;
import com.viit0r.listacomprasapi.model.entity.Produto;
import com.viit0r.listacomprasapi.model.request.ItemRequestDTO;
import com.viit0r.listacomprasapi.model.request.ListaRequestDTO;
import com.viit0r.listacomprasapi.model.request.ProdutoRequestDTO;
import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import com.viit0r.listacomprasapi.model.response.ListaResponseDTO;
import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public List<ProdutoResponseDTO> toProdutosDTO(List<Produto> produtos) {
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    public List<ListaResponseDTO> toListasDTO(List<Lista> listas) {
        return listas.stream().map(ListaResponseDTO::new).collect(Collectors.toList());
    }

    public List<ItemResponseDTO> toItensDTO(List<Item> itens) {
        return itens.stream().map(ItemResponseDTO::new).collect(Collectors.toList());
    }

    public ProdutoResponseDTO toProdutoDTO(Produto produto) {
        return new ProdutoResponseDTO(produto);
    }

    public ListaResponseDTO toListaDTO(Lista lista) {
        return new ListaResponseDTO(lista);
    }

    public ItemResponseDTO toItemDTO(Item item) {
        return new ItemResponseDTO(item);
    }

    public Lista toLista(ListaRequestDTO listaDTO) {
        return Lista.builder().
                nome(listaDTO.getNome())
                .dataCriacao(listaDTO.getDataCriacao())
                .limiteGasto(listaDTO.getLimiteGasto())
                .valorTotal(listaDTO.getValorTotal() != null ? listaDTO.getValorTotal() : 0.0)
                .build();
    }

    public Produto toProduto(ProdutoRequestDTO produtoDTO) {
        return Produto.builder()
                    .nome(produtoDTO.getNome())
                    .valorUnitario(produtoDTO.getValorUnitario())
                    .build();
    }

    public Item toItem(ItemRequestDTO itemDTO) {
        return Item.builder()
                .coletado(itemDTO.getColetado())
                .qtde(itemDTO.getQtde())
                .produto(toProduto(itemDTO.getProduto()))
                .lista(toLista(itemDTO.getLista()))
                .build();
    }
}
