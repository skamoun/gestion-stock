package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Article;
import com.kamoun.gestiondestock.model.CommandeFournisseur;
import com.kamoun.gestiondestock.model.LigneCommandeClient;
import com.kamoun.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeFournisseurDto {
    private Integer id ;

    private ArticleDto article ;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal prixUnit;

    private BigDecimal quantite;
    public static LigneCommandeFournisseurDto  fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur==null){
            // TODO throw an exception
            return null;
        }
        return  LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .prixUnit(ligneCommandeFournisseur.getPrixUnit())
                .quantite(ligneCommandeFournisseur.getQuantite())

                .build();
    }

    public static  LigneCommandeFournisseur  toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto==null){
            // TODO throw an exception
            return null;
        }
        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.id);
        ligneCommandeFournisseur.setPrixUnit(ligneCommandeFournisseurDto.prixUnit);
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.quantite);

        return  ligneCommandeFournisseur;
    }
}
