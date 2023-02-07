package com.kamoun.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ventes")
public class Vente extends AbstractEntity{
    @Column(name = "_code")
    private String code;
    @Column(name = "_date_vente")
    private Instant dateVente;
    @Column(name = "_commentaire")
    private String commentaire;


}