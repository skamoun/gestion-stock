package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.LigneVenteDto;

import java.util.List;

public interface LigneVenteService {
    LigneVenteDto save(LigneVenteDto ligneVenteDto);

    LigneVenteDto findById(Integer id);

    LigneVenteDto findByCode(String code);

    List<LigneVenteDto> findAll();

    void delete(Integer id);
}
