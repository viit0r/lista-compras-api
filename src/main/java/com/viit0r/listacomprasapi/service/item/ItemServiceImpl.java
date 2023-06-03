package com.viit0r.listacomprasapi.service.item;

import com.viit0r.listacomprasapi.model.entity.Item;
import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import com.viit0r.listacomprasapi.repository.ItemRepository;
import com.viit0r.listacomprasapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    Mapper itemMapper;

    @Override
    public List<ItemResponseDTO> findAll() {
        List<Item> itens = itemRepository.findAll();
        return itemMapper.toItensDTO(itens);
    }
}
