package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.CommandeClient;
import com.kamoun.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class LigneCommandeClientDto {
    private Integer id ;



    private ArticleDto article ;

    private CommandeClientDto commandeClient;

    private BigDecimal prixUnit;

    private BigDecimal quantite;
    public static LigneCommandeClientDto  fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient==null){
            // TODO throw an exception
            return null;
        }
        return  LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .prixUnit(ligneCommandeClient.getPrixUnit())
                .quantite(ligneCommandeClient.getQuantite())

                .build();
    }

    public static  LigneCommandeClient  toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto==null){
            // TODO throw an exception
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.id);
        ligneCommandeClient.setPrixUnit(ligneCommandeClientDto.prixUnit);
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.quantite);

        return  ligneCommandeClient;
    }
}
