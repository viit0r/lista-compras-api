package com.viit0r.listacomprasapi.util;

import com.viit0r.listacomprasapi.model.entity.Lista;
import com.viit0r.listacomprasapi.model.entity.Produto;
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
}
