package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.LigneCommandeFournisseur;
import com.kamoun.gestiondestock.model.LigneVente;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Integer id ;

    private VenteDto ventes;
    @Column(name = "_quantite")
    private BigDecimal quantite;
    @Column(name = "_prix_unit")
    private BigDecimal prixUnit;

    public static LigneVenteDto  fromEntity(LigneVente ligneVente){
        if(ligneVente==null){
            // TODO throw an exception
            return null;
        }
        return  LigneVenteDto.builder()
                .id(ligneVente.getId())
                .prixUnit(ligneVente.getPrixUnit())
                .quantite(ligneVente.getQuantite())

                .build();
    }

    public static  LigneVente  toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto==null){
            // TODO throw an exception
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.id);
        ligneVente.setPrixUnit(ligneVenteDto.prixUnit);
        ligneVente.setQuantite(ligneVenteDto.quantite);

        return  ligneVente;
    }
}
