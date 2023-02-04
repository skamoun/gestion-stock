package com.kamoun.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ligne_vente")
public class LigneVente extends AbstractEntity{
    private static final String VENTES_JOIN_COLUMN ="_id_ventes" ;
    @ManyToOne
    @JoinColumn(name = VENTES_JOIN_COLUMN)
    private Ventes ventes;
    @Column(name = "_quantite")
    private BigDecimal quantite;
}
