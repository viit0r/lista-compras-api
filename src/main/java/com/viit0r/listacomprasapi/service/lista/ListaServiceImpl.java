package com.viit0r.listacomprasapi.service.lista;

import com.viit0r.listacomprasapi.model.entity.Lista;
import com.viit0r.listacomprasapi.model.request.ListaRequestDTO;
import com.viit0r.listacomprasapi.model.response.ListaResponseDTO;
import com.viit0r.listacomprasapi.repository.ListaRepository;
import com.viit0r.listacomprasapi.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListaServiceImpl implements ListaService{

    @Autowired
    ListaRepository listaRepository;

    @Autowired
    Mapper listaMapper;

    @Override
    public List<ListaResponseDTO> findAll() {
        List<Lista> listas = listaRepository.findAll();
        return listaMapper.toListasDTO(listas);
    }

    @Override
    public ListaResponseDTO create(ListaRequestDTO listaDTO) {
        Lista lista = listaMapper.toLista(listaDTO);
        lista.setDataCriacao(new Date());
        return listaMapper.toListaDTO(listaRepository.save(lista));
    }
}
