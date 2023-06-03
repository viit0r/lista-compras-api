package com.viit0r.listacomprasapi.service.produto;

import com.viit0r.listacomprasapi.model.entity.Produto;
import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;
import com.viit0r.listacomprasapi.repository.ProdutoRepository;
import com.viit0r.listacomprasapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    Mapper produtoMapper;

    @Override
    public List<ProdutoResponseDTO> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtoMapper.toProdutos(produtos);
    }
}
