package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
public class Article extends AbstractEntity{
    private final static String CATEGORY_JOIN_COLUMN="_id_category";
    @Column(name = "_code")
    private String code;
    @Column(name = "_designation")
    private String designation;
    @Column(name = "_prix_unit_ht")
    private BigDecimal prixUnitHt;
    @Column(name = "_taux_tva")
    private BigDecimal tauxTva;
    @Column(name = "_prix_unit_ttc")
    private BigDecimal prixUnitTtc;
    @Column(name = "_photo")
    private String photo;
    @Column(name = "_id_entreprise")
    private Integer idEntreprise;


    @ManyToOne
    @JoinColumn(name = CATEGORY_JOIN_COLUMN)
    private Category category;


    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;
}
