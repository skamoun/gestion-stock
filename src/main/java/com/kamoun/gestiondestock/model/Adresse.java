package com.kamoun.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    @Column(name = "_adresse1")
    private String adresse1;
    @Column(name = "_adresse2")
    private String adresse2;
    @Column(name = "_ville")
    private String ville;
    @Column(name = "_code_postal")
    private String codePostal;
    @Column(name = "_pays")
    private String pays;

}
