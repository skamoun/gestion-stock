package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
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

    @ManyToOne
    @JoinColumn(name = CATEGORY_JOIN_COLUMN)
    private Category category;
}
