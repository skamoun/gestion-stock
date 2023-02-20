package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.ClientDto;
import com.kamoun.gestiondestock.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    @Override
    public ClientDto save(ClientDto dto) {
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
