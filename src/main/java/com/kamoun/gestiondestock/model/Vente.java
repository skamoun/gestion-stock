package com.kamoun.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventes")
public class Vente extends AbstractEntity {
    @Column(name = "_code")
    private String code;
    @Column(name = "_date_vente")
    private Instant dateVente;
    @Column(name = "_commentaire")
    private String commentaire;
    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;


}
