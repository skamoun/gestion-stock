package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
