package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.CommandeFournisseur;
import com.kamoun.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder

public class CommandeFournisseurDto {
    private Integer id ;

    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;

    private FournisseurDto fournisseur;
    private Integer idEntreprise;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto  fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur==null){
            // TODO throw an exception
            return null;
        }
        return  CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .dateCommande(commandeFournisseur.getDateCommande())
                .code(commandeFournisseur.getCode())

                .build();
    }

    public static  CommandeFournisseur  toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto==null){
            // TODO throw an exception
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());

        return  commandeFournisseur;
    }
}
