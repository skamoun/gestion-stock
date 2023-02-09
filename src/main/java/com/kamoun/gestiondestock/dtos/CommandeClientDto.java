package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Client;
import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
@Data
@Builder

public class CommandeClientDto {
    private Integer id ;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto  fromEntity(CommandeClient commandeClient){
        if(commandeClient==null){
            // TODO throw an exception
            return null;
        }
        return  CommandeClientDto.builder()
                .id(commandeClient.getId())
                .dateCommande(commandeClient.getDateCommande())
                .code(commandeClient.getCode())

                .build();
    }

    public static  CommandeClient  toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto==null){
            // TODO throw an exception
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());

        return  commandeClient;
    }
}
