package com.kamoun.gestiondestock.controller.impl;

import com.kamoun.gestiondestock.controller.api.EntrepriseApi;
import com.kamoun.gestiondestock.dtos.EntrepriseDto;
import com.kamoun.gestiondestock.services.EntrepriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EntrepriseController implements EntrepriseApi {
    private final EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);

    }
}
