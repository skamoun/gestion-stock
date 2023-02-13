package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ligne_vente")
public class LigneVente extends AbstractEntity {
    private static final String VENTES_JOIN_COLUMN = "_id_ventes";
    private static final String ARTICLE_JOIN_COLUMN = "_id_article";
    @ManyToOne
    @JoinColumn(name = VENTES_JOIN_COLUMN)
    private Vente ventes;
    @Column(name = "_quantite")
    private BigDecimal quantite;
    @Column(name = "_prix_unit")
    private BigDecimal prixUnit;
    @ManyToOne
    @JoinColumn(name = ARTICLE_JOIN_COLUMN)
    private Article article;
}
