package com.kamoun.gestiondestock.services;

import com.kamoun.gestiondestock.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByCode(String code);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
