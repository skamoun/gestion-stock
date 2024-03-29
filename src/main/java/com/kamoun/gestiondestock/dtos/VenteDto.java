package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class VenteDto {
    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;
    private List<LigneVenteDto> ligneVentes;

    public static VenteDto  fromEntity(Vente vente){
        if(vente==null){
            // TODO throw an exception
            return null;
        }
        return  VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())

                .build();
    }

    public static  Vente  toEntity(VenteDto venteDto){
        if(venteDto==null){
            // TODO throw an exception
            return null;
        }
        Vente vente = new Vente();
        vente.setId(venteDto.id);
        vente.setDateVente(venteDto.dateVente);
        vente.setCode(venteDto.getCode());
        vente.setCommentaire(venteDto.getCommentaire());

        return  vente;
    }

}
