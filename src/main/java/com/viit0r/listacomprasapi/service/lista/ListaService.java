package com.viit0r.listacomprasapi.service.lista;

import com.viit0r.listacomprasapi.model.request.ListaRequestDTO;
import com.viit0r.listacomprasapi.model.response.ListaResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListaService {

    List<ListaResponseDTO> findAll();

    ListaResponseDTO create(ListaRequestDTO listaDTO);
}
