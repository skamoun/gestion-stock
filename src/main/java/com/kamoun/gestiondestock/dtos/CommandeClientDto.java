package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class CommandeClientDto {
    private Integer id;

    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private ClientDto client;

    private Integer idEntreprise;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            // TODO throw an exception
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .dateCommande(commandeClient.getDateCommande())
                .code(commandeClient.getCode())
                .idEntreprise(commandeClient.getIdEntreprise())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .ligneCommandeClients(commandeClient.getLigneCommandeClients().stream()
                        .map(LigneCommandeClientDto::fromEntity).toList())
                .build();
    }

    public static  CommandeClient  toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            // TODO throw an exception
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setEtatCommande(commandeClientDto.getEtatCommande());
        commandeClient.setLigneCommandeClients(commandeClientDto.getLigneCommandeClients().stream()
                .map(LigneCommandeClientDto::toEntity).toList());

        return commandeClient;
    }
}
