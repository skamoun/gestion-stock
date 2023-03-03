package com.kamoun.gestiondestock.controller.impl;

import com.kamoun.gestiondestock.controller.api.FournisseurApi;
import com.kamoun.gestiondestock.dtos.FournisseurDto;
import com.kamoun.gestiondestock.services.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FournisseurController implements FournisseurApi {
    private final FournisseurService fournisseurService;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
