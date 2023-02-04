package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commande_fournisseur")
public class CommandeFournisseur extends AbstractEntity{
    private static final String FOURNISSEUR_JOIN_COLUMN ="_id_fournisseur" ;
    @Column(name = "_code")
    private String code;
    @Column(name = "_date_commande")
    private LocalDate dateCommande;
    @ManyToOne()
    @JoinColumn(name = FOURNISSEUR_JOIN_COLUMN)
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
