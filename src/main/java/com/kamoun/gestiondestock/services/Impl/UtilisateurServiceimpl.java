package com.kamoun.gestiondestock.services.Impl;

import com.kamoun.gestiondestock.dtos.UtilisateurDto;
import com.kamoun.gestiondestock.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceimpl implements UtilisateurService {
    private final UtilisateurService utilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByCode(String code) {
        return null;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
