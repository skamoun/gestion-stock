package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.CommandeFournisseur;
import com.kamoun.gestiondestock.model.Fournisseur;
import com.kamoun.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
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

public class CommandeFournisseurDto {
    private Integer id ;

    @Column(name = "_code")
    private String code;
    @Column(name = "_date_commande")
    private Instant dateCommande;

    private FournisseurDto fournisseur;

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
