package com.kamoun.gestiondestock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {
    private static final String ARTICLE_JOIN_COLUMN = "_id_article";
    private static final String COMMANDE_FOURNISSEUR_JOIN_COLUMN = "_id_commande_fournisseur";
    @ManyToOne
    @JoinColumn(name = ARTICLE_JOIN_COLUMN)
    private Article article ;
    @ManyToOne
    @JoinColumn(name = COMMANDE_FOURNISSEUR_JOIN_COLUMN)
    private CommandeFournisseur commandeFournisseur;
}
