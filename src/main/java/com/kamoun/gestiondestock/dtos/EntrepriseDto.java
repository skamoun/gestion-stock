package com.kamoun.gestiondestock.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class EntrepriseDto {

    private String nom;

    private String _description;

    private String _codeFiscal;

    private String email;

    private AdresseDto adresse ;

    private String photo;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;


}
