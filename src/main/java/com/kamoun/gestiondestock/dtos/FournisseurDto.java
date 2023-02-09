package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Adresse;
import com.kamoun.gestiondestock.model.CommandeFournisseur;
import com.kamoun.gestiondestock.model.Entreprise;
import com.kamoun.gestiondestock.model.Fournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FournisseurDto {
    private Integer id ;



    private String nom;

    private String prenom;

    private String mail;

    private AdresseDto adresse ;

    private String photo;

    private String numTel;

    private List<CommandeFournisseurDto> commandeFournisseurs;


    public static FournisseurDto  fromEntity(Fournisseur fournisseur){
        if(fournisseur==null){
            // TODO throw an exception
            return null;
        }
        return  FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .photo(fournisseur.getPhoto())
                .prenom(fournisseur.getPrenom())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .build();
    }

    public static  Fournisseur  toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto==null){
            // TODO throw an exception
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.id);
        fournisseur.setMail(fournisseurDto.mail);
        fournisseur.setNom(fournisseurDto.nom);
        fournisseur.setPrenom(fournisseurDto.prenom);
        fournisseur.setPhoto(fournisseurDto.photo);
        fournisseur.setNumTel(fournisseurDto.numTel);


        return  fournisseur;
    }

}
