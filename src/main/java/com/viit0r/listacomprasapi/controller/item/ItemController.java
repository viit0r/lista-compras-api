package com.viit0r.listacomprasapi.controller.item;

import com.viit0r.listacomprasapi.model.request.ItemRequestDTO;
import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import com.viit0r.listacomprasapi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> findAll() {
        return ResponseEntity.ok().body(itemService.findAll());
    }

    @PostMapping
    public ResponseEntity<ItemResponseDTO> create(@RequestBody ItemRequestDTO itemDTO, UriComponentsBuilder uriBuilder) {
        ItemResponseDTO itemResponseDTO = itemService.create(itemDTO);
        URI uri = uriBuilder.path("/item/{id}").buildAndExpand(itemResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(itemResponseDTO);
    }
}
