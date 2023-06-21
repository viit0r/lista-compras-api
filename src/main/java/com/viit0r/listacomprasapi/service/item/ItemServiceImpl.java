package com.viit0r.listacomprasapi.service.item;

import com.viit0r.listacomprasapi.model.entity.Item;
import com.viit0r.listacomprasapi.model.entity.Lista;
import com.viit0r.listacomprasapi.model.request.ItemRequestDTO;
import com.viit0r.listacomprasapi.model.response.ItemResponseDTO;
import com.viit0r.listacomprasapi.repository.ItemRepository;
import com.viit0r.listacomprasapi.repository.ListaRepository;
import com.viit0r.listacomprasapi.repository.ProdutoRepository;
import com.viit0r.listacomprasapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ListaRepository listaRepository;

    @Autowired
    Mapper itemMapper;

    @Override
    public List<ItemResponseDTO> findAll() {
        List<Item> itens = itemRepository.findAll();
        return itemMapper.toItensDTO(itens);
    }

    @Override
    public List<ItemResponseDTO> findByIdLista(Long id) {
        List<Item> itens = itemRepository.findByIdLista(id);
        return itemMapper.toItensDTO(itens);
    }

    @Override
    public ItemResponseDTO create(ItemRequestDTO itemDTO) {

        Item item = itemMapper.toItem(itemDTO);

        item.setLista(recuperaLista(itemDTO.getLista().getId()));

        if(!existeProduto(itemDTO.getProduto().getId())) {
            item.setProduto(
                    produtoRepository.save(
                            itemMapper.toProduto(itemDTO.getProduto())
                    ));
        }
        else {
            item.setProduto(produtoRepository.findById(itemDTO.getProduto().getId()).get());
        }

        item.setValorTotal(item.getQtde() * item.getProduto().getValorUnitario());

        item = itemRepository.save(item);

        if (item.getId() != null) {
            atualizaValorTotalLista(item.getLista(), item.getValorTotal());
        }

        return itemMapper.toItemDTO(item);
    }

    private void atualizaValorTotalLista(Lista lista, Double valorTotal) {
        lista.setValorTotal(lista.getValorTotal() + valorTotal);
        listaRepository.save(lista);
    }

    private Lista recuperaLista(Long id) {
        return listaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada."));
    }

    private boolean existeProduto(Long id) {
        if (id == null)
            return false;
        return produtoRepository.findById(id).isPresent();
    }
}
