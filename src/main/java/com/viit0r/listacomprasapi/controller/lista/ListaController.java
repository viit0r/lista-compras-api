package com.viit0r.listacomprasapi.controller.lista;

import com.viit0r.listacomprasapi.model.request.ListaRequestDTO;
import com.viit0r.listacomprasapi.model.response.ListaResponseDTO;
import com.viit0r.listacomprasapi.service.lista.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {

    @Autowired
    ListaService listaService;

    @GetMapping
    public ResponseEntity<List<ListaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(listaService.findAll());
    }

    @PostMapping
    public ResponseEntity<ListaResponseDTO> create(@RequestBody ListaRequestDTO listaDTO, UriComponentsBuilder uriBuilder) {
        ListaResponseDTO listaResponseDTO = listaService.create(listaDTO);
        URI uri = uriBuilder.path("/lista/{id}").buildAndExpand(listaResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(listaResponseDTO);
    }
}
