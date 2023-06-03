package com.viit0r.listacomprasapi.controller.item;

import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import com.viit0r.listacomprasapi.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
