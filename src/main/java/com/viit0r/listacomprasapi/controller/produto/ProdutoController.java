package com.viit0r.listacomprasapi.controller.produto;

import com.viit0r.listacomprasapi.model.request.ProdutoRequestDTO;
import com.viit0r.listacomprasapi.model.response.ProdutoResponseDTO;
import com.viit0r.listacomprasapi.service.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> create(@RequestBody ProdutoRequestDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        ProdutoResponseDTO produtoResponseDTO = produtoService.create(produtoDTO);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoResponseDTO);
    }
}
