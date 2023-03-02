package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.LigneCommandeClientDto;

import java.util.List;

public interface LigneCommandeClientService {
    LigneCommandeClientDto save(LigneCommandeClientDto ligneCommandeClientDto);

    LigneCommandeClientDto findById(Integer id);

    LigneCommandeClientDto findByCode(String code);

    List<LigneCommandeClientDto> findAll();

    void delete(Integer id);
}
