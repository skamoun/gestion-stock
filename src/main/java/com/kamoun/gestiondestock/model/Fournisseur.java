package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity{

    @Column(name = "_nom")
    private String nom;
    @Column(name = "_prenom")
    private String prenom;
    @Column(name = "_email")
    private String mail;
    @Embedded
    private Adresse adresse ;
    @Column(name = "_photo")
    private String photo;
    @Column(name = "_num_tel")
    private String numTel;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
