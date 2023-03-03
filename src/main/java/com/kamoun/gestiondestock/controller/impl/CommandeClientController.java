package com.kamoun.gestiondestock.controller.impl;

import com.kamoun.gestiondestock.controller.api.CommandeClientApi;
import com.kamoun.gestiondestock.dtos.CommandeClientDto;
import com.kamoun.gestiondestock.services.CommandeClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommandeClientController implements CommandeClientApi {

    private final CommandeClientService commandeClientService;

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer idCommandeClient) {
        return ResponseEntity.ok(commandeClientService.findById(idCommandeClient));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
