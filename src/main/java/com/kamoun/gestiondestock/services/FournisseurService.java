package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByCode(String code);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
