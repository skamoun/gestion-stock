package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.LigneCommandeFournisseurDto;

import java.util.List;

public interface LigneCommandeFournissuerService {
    LigneCommandeFournisseurDto save(LigneCommandeFournisseurDto ligneCommandeFournisseurDto);

    LigneCommandeFournisseurDto findById(Integer id);

    LigneCommandeFournisseurDto findByCode(String code);

    List<LigneCommandeFournisseurDto> findAll();

    void delete(Integer id);
}
