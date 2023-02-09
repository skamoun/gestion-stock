package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class UtilisateurDto {

        private Integer id ;

        private String nom;

        private String prenom;

        private String dateNaissance;

        private String mail;

        private String password;

        private AdresseDto adresse ;

        private String photo;

        private EntrepriseDto entreprise;

        private List<RolesDto> roles;

        public static UtilisateurDto  fromEntity(Utilisateur utilisateur){
                if(utilisateur==null){
                        // TODO throw an exception
                        return null;
                }
                return  UtilisateurDto.builder()
                        .id(utilisateur.getId())
                        .mail(utilisateur.getMail())
                        .nom(utilisateur.getNom())
                        .photo(utilisateur.getPhoto())
                        .prenom(utilisateur.getPrenom())
                        .dateNaissance(utilisateur.getDateNaissance())
                        .password(utilisateur.getPassword())
                        .build();
        }

        public static  Utilisateur  toEntity(UtilisateurDto utilisateurDto){
                if(utilisateurDto==null){
                        // TODO throw an exception
                        return null;
                }
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(utilisateurDto.getId());
                utilisateur.setNom(utilisateurDto.getNom());
                utilisateur.setPrenom(utilisateurDto.getPrenom());
                utilisateur.setPhoto(utilisateurDto.getPhoto());
                utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
                utilisateur.setMail(utilisateurDto.mail);
                utilisateur.setPassword(utilisateurDto.password);

                return  utilisateur;
        }




}
