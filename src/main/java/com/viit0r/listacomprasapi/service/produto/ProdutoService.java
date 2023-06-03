package com.viit0r.listacomprasapi.service.produto;

import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {

    List<ProdutoResponseDTO> findAll();
}
