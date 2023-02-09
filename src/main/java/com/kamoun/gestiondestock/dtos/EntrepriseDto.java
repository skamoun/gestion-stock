package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.CommandeFournisseur;
import com.kamoun.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class EntrepriseDto {
    private Integer id ;


    private String nom;

    private String description;

    private String codeFiscal;

    private String email;

    private AdresseDto adresse ;

    private String photo;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto  fromEntity(Entreprise entreprise){
        if(entreprise==null){
            // TODO throw an exception
            return null;
        }
        return  EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .photo(entreprise.getPhoto())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getMail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())


                .build();
    }

    public static  Entreprise  toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto==null){
            // TODO throw an exception
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setMail(entrepriseDto.getEmail());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.description);
        entreprise.setPhoto(entrepriseDto.photo);
        entreprise.setNumTel(entrepriseDto.numTel);
        entreprise.setSiteWeb(entrepriseDto.siteWeb);
        entreprise.setCodeFiscal(entrepriseDto.codeFiscal);


        return  entreprise;
    }


}
