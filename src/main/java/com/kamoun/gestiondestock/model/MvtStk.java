package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mvt_stock")
public class MvtStk extends AbstractEntity{
    private static final String ARTICLE_JOIN_COLUMN = "_id_article";
    @Column(name = "_quantite")
    private BigDecimal quantite;
    @Column(name = "_date_mvt")
    private Instant dateMvt;
    @ManyToOne
    @JoinColumn(name = ARTICLE_JOIN_COLUMN)
    private Article article ;
    @Column(name = "_type_mvt_stock")
    @Enumerated(EnumType.STRING)
    private TypeMvtStock typeMvtStock;
}
