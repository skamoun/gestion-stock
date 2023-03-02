package com.kamoun.gestiondestock.controller.impl;

import com.kamoun.gestiondestock.controller.api.ClientApi;
import com.kamoun.gestiondestock.dtos.ClientDto;
import com.kamoun.gestiondestock.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements ClientApi {
    private final ClientService clientService;

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
