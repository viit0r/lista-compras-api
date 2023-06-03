package com.viit0r.listacomprasapi.controller.lista;

import com.viit0r.listacomprasapi.model.response.ListaResponseDTO;
import com.viit0r.listacomprasapi.service.lista.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
