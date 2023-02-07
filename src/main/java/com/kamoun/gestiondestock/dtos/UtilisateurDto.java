package com.kamoun.gestiondestock.dtos;

import com.kamoun.gestiondestock.model.Adresse;
import com.kamoun.gestiondestock.model.Entreprise;
import com.kamoun.gestiondestock.model.Roles;
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



        }
