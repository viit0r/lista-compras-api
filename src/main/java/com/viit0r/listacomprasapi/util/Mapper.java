package com.viit0r.listacomprasapi.util;

import com.viit0r.listacomprasapi.model.entity.Produto;
import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public List<ProdutoResponseDTO> toProdutos(List<Produto> produtos) {
        return produtos.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }
}
