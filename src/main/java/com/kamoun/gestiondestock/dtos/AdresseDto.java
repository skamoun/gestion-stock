package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Adresse;
import com.kamoun.gestiondestock.model.Category;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdresseDto {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostal;

    private String pays;

    public AdresseDto  fromEntity(Adresse adresse){
        if(adresse==null){
            // TODO throw an exception
            return null;
        }
        return  AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .pays(adresse.getPays())
                .ville(adresse.getVille())
                .codePostal(adresse.getCodePostal())
                .build();
    }

    public Adresse  toEntity(AdresseDto adresseDto){
        if(adresseDto==null){
            // TODO throw an exception
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresse.getAdresse1());
        adresse.setAdresse2(adresse.getAdresse2());
        adresse.setPays(adresse.getPays());
        adresse.setVille(adresse.getVille());
        adresse.setCodePostal(adresse.getCodePostal());

        return  adresse;
    }
}
