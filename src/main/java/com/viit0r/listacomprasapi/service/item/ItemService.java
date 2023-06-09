package com.viit0r.listacomprasapi.service.item;

import com.viit0r.listacomprasapi.model.request.ItemRequestDTO;
import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<ItemResponseDTO> findAll();

    List<ItemResponseDTO> findByIdLista(Long id);

    ItemResponseDTO create(ItemRequestDTO itemDTO);
}