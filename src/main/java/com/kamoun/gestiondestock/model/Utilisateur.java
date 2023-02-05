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
@Table(name = "utilisateurs")
public class Utilisateur extends AbstractEntity{
    private static final String ENTREPRISE_JOIN_COLUMN = "_id_entreprise";
    @Column(name = "_nom")
    private String nom;
    @Column(name = "_prenom")
    private String prenom;
    @Column(name = "_date_naissance")
    private String dateNaissance;
    @Column(name = "_email")
    private String mail;
    @Column(name = "_password")
    private String password;
    @Embedded
    private Adresse adresse ;
    @Column(name = "_photo")
    private String photo;
@ManyToOne
@JoinColumn(name = ENTREPRISE_JOIN_COLUMN)
    private Entreprise entreprise;
@OneToMany(mappedBy = "utilisateur")
private List<Roles> roles;
}
