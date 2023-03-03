package com.kamoun.gestiondestock.controller.impl;

import com.kamoun.gestiondestock.controller.api.CommandeFournisseurApi;
import com.kamoun.gestiondestock.dtos.CommandeFournisseurDto;
import com.kamoun.gestiondestock.services.CommandeFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class CommandeFournisseurController implements CommandeFournisseurApi {
    private final CommandeFournisseurService commandeFournisseurService;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }


    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        commandeFournisseurService.delete(id);
    }
}
