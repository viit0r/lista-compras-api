package com.viit0r.listacomprasapi.controller.produto;

import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;
import com.viit0r.listacomprasapi.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(produtoService.findAll());
    }
}
