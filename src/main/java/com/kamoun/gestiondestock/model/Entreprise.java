package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity{
    @Column(name = "_nom")
    private String nom;
    @Column(name = "_description")
    private String description;
    @Column(name = "_code_fiscal")
    private String codeFiscal;
    @Column(name = "_email")
    private String mail;
    @Embedded
    private Adresse adresse ;
    @Column(name = "_photo")
    private String photo;
    @Column(name = "_num_tel")
    private String numTel;
    @Column(name = "_site_web")
    private String siteWeb;
    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;


}
