package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {
    private static final String ARTICLE_JOIN_COLUMN = "_id_article";
    private static final String COMMANDE_FOURNISSEUR_JOIN_COLUMN = "_id_commande_fournisseur";
    @ManyToOne
    @JoinColumn(name = ARTICLE_JOIN_COLUMN)
    private Article article;
    @ManyToOne
    @JoinColumn(name = COMMANDE_FOURNISSEUR_JOIN_COLUMN)
    private CommandeFournisseur commandeFournisseur;
    @Column(name = "_prix_unit")
    private BigDecimal prixUnit;
    @Column(name = "_quantite")
    private BigDecimal quantite;
    @Column(name = "_id_entreprise")
    private Integer idEntreprise;
}
