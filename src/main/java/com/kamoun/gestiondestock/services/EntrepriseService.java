package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto articleDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCode(String code);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
