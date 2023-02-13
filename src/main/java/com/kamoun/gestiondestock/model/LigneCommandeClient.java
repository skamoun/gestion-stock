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
@Table(name = "ligne_commande_client")
public class LigneCommandeClient extends AbstractEntity{
    private static final String ARTICLE_JOIN_COLUMN = "_id_article";
    private static final String COMMANDE_CLIENT_JOIN_COLUMN = "_id_commande_client";
    @ManyToOne
    @JoinColumn(name = ARTICLE_JOIN_COLUMN)
    private Article article ;
    @ManyToOne
    @JoinColumn(name = COMMANDE_CLIENT_JOIN_COLUMN)
    private CommandeClient commandeClient;
    @Column(name = "_prix_unit")
    private BigDecimal prixUnit;
    @Column(name = "_quantite")
    private BigDecimal quantite;

}
