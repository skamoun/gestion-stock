package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.VenteDto;

import java.util.List;

public interface VentesService {
    VenteDto save(VenteDto dto);

    VenteDto findById(Integer id);

    List<VenteDto> findAll();

    void delete(Integer id);

}
